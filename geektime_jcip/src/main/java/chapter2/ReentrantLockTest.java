package chapter2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/9/15 1:15 上午
 */

public class ReentrantLockTest {
    public static void test() throws Exception {
        // 1.初始化锁时可以指明锁类型，默认初始化类型是 非公平锁
        ReentrantLock lock = new ReentrantLock(true);

        // 2.给代码块加锁
        lock.lock();
        try {
            try {
                // 3.支持多种加锁方式，具有可重入性
                if(lock.tryLock(100, TimeUnit.MILLISECONDS)) {
                    System.out.println("666");
                    // 业务逻辑
                }
            } finally {
                // 4.在 finally 中手动释放锁，try-finally 是 Lock 的编程范式，需要保证锁的释放
                lock.unlock();
            }
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        test();
    }
}
