package chapter5;

import java.util.concurrent.CountDownLatch;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/6 8:45 下午
 */

// Using CountDownLatch for starting and stopping threads in timing tests
// 使用 CountDownLatch 来计算 方法执行的耗时
public class TestHarness {
    public long timeTask(int nThreads, final Runnable task) throws InterruptedException {
        // 起始闭锁 初始值为1
        final CountDownLatch startGate = new CountDownLatch(1);
        // 结束闭锁 初始值为传入的线程值
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        // 根据传入的线程数 循环执行task 每次执行 endGate 都会 -1
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }

                    } catch (InterruptedException e) {
                        // 啥也不做
                    }
                }
            };
            // 使线程开始执行
            t.start();
        }
        long start = System.nanoTime();
        // 起始闭锁 -1 ，闭锁结束
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}
