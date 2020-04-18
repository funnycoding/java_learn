package chapter7;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/16 1:26 下午
 */

// 使用中断机制来取消任务
public class PrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;

    public PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted()) {
                queue.put(p = p.nextProbablePrime());
            }
        } catch (InterruptedException e) {
            // 允许 Thread 退出
        }
    }
    // 这里中断任务不再是设置 cancellable 的值，而是直接调用 Thread 的 interrupt() 方法
    public void cancel() {
        interrupt();
    }
}
