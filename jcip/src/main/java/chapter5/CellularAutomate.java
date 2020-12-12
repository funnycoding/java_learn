package chapter5;

import java.util.concurrent.CyclicBarrier;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/6 10:53 下午
 */

// 使用栅栏协调计算细胞衍生系统
public class CellularAutomate {
    private final Board mainBoard;
    private final CyclicBarrier barrier;
    private final Worker[] workers;


    public CellularAutomate(Board board) {
        this.mainBoard = board;
        int count = Runtime.getRuntime().availableProcessors();
        this.barrier = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                mainBoard.commitNewValues();
            }
        });
        // 有几个 CPU 就创建一个对应数量的 worker 数组 用来真正的执行计算
        this.workers = new Worker[count];
        for (int i = 0; i < count; i++) {
            // 构造 worker 对象
            workers[i] = new Worker(mainBoard.getSubBoard(count, i));
        }
    }

    /**
     * 真正执行计算的类
     */
    private class Worker implements Runnable {
        private final Board board;

        public Worker(Board board) {
            this.board = board;
        }

        @Override
        public void run() {
            while (!board.hasConverged()) {
                for (int x = 0; x < board.getMaxX(); x++) {
                    for (int y = 0; y < board.getMaxY(); y++) {
                        board.setNewValue(x, y, computeValue(x, y));
                    }
                }
            }
        }

        private int computeValue(int x, int y) {
            // 一个根据 x,y值 计算新的 value 的业务逻辑方法
            return 0;
        }
    }

    // 启动所有 worker
    public void start() {
        for (int i = 0; i < workers.length; i++) {
            new Thread(workers[i]).start();
        }
        mainBoard.waitForConvergence();
    }

    interface Board {
        int getMaxX();

        int getMaxY();

        int getValue(int x, int y);

        int setNewValue(int x, int y, int value);

        void commitNewValues();

        boolean hasConverged();

        //Convergence -> 自动收敛的点
        void waitForConvergence();

        // Partitions -> 隔离物
        Board getSubBoard(int numPartitions, int index);
    }
}
