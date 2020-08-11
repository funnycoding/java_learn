package chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/8/11 3:31 下午
 */

// 简化的线程池实现，仅用来说明工作原理
public class MyThreadPool {
    // 利用阻塞队列实现生产者—消费者模式
    BlockingQueue<Runnable> workQueue;

    // 保存内部工作线程
    List<WorkerThread> threads = new ArrayList<>();

    // 构造函数
    public MyThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        // 创建工作线程
        for (int index = 0; index < poolSize; index++) {
            WorkerThread work = new WorkerThread();
            work.start();
            threads.add(work);
        }
    }

    // 提交任务
    void execute(Runnable command) throws InterruptedException {
        workQueue.put(command);
    }

    // 工作线程负责消费任务，并执行任务
    class WorkerThread extends Thread {
        @Override
        public void run() {
            // 循环获取任务并执行
            while (true) {
                Runnable task = null;
                try {
                    task = workQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                task.run();
            }
        }
    }

    /** 下面是使用示例 **/
    public static void main(String[] args) throws InterruptedException {
        // 创建有界队列
        BlockingQueue workQueue = new LinkedBlockingQueue<>(2);

        // 创建线程池
        MyThreadPool pool = new MyThreadPool(10, workQueue);

        // 提交任务
        pool.execute(() -> System.out.println("hello"));
    }
}

