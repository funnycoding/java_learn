package chapter7;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/15 9:55 下午
 */
// 通过一个被 volatile 修饰的标志位来判断任务是否被取消
@ThreadSafe
public class PrimeGenerator implements Runnable {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    @GuardedBy("this")
    private final List<BigInteger> primes = new ArrayList<>();

    private volatile boolean cancelled;

    @Override
    public void run() {
        System.out.println("任务被开启了！");
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            //System.out.println("p = " + p.toString());
            synchronized (this) {
                primes.add(p);
            }
        }
    }


    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }
    // 另外添加一个计算素数的任务
    static List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        System.out.println("aSecondOfPrimes 被调用了");
        final PrimeGenerator generator = new PrimeGenerator();
        exec.execute(generator);
        try {
            SECONDS.sleep(1);
        } finally {
            generator.cancel();
        }
        return generator.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final PrimeGenerator primeGenerator = new PrimeGenerator();
        final Thread thread = new Thread(primeGenerator);
        thread.start();
        thread.sleep(10);
        PrimeGenerator.aSecondOfPrimes();
        Thread.sleep(1);
    }
}
