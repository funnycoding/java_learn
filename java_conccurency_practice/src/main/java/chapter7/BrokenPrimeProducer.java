package chapter7;

import java.math.BigInteger;
import java.security.cert.TrustAnchor;
import java.util.concurrent.BlockingQueue;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/16 11:21 上午
 */
// Unreliable cancellation that can leave producers stuck in a blocking operation
// 当阻塞队列被填满时，cancel 操作无法正确进行，因为 put 被阻塞
public class BrokenPrimeProducer extends Thread {
    // 阻塞队列
    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;

    public BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!cancelled) {
                queue.put(p = p.nextProbablePrime());
            }
        } catch (InterruptedException e) {

        }
    }

    public void cancel() {
        cancelled = true;
    }
}
