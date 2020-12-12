import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/8/9 2:55 上午
 */

public class CPUErroDemo {

    final StampedLock sl = new StampedLock();

    // 乐观读
    void test() {
        long stamp = sl.tryOptimisticRead();

        // 将共享变量赋值给方法局部变量
        //校验stamp
        if (!sl.validate(stamp)) {
            // 升级为悲观读锁
            stamp = sl.readLock();
        }
        try {
            // 将共享变量赋值给方法局部变量
        } finally {
            // 释放悲观读锁
            sl.unlockRead(stamp);
        }
    }
    // 变量的获取完毕，下面就是使用这个局部变量的业务逻辑


    final static StampedLock lock = new StampedLock();


    public static void main(String[] args) throws InterruptedException {



        Thread t1 = new Thread(() -> {
            // 获取写锁
            lock.writeLock();
            // 永远阻塞在这里，不释放写锁
            LockSupport.park();
        });
        t1.start();

        // 保证T1 获取写锁
        Thread.sleep(100);

        Thread t2 = new Thread(() -> {
            // 阻塞在悲观读锁
            lock.readLock();
        });
        t2.start();
        // 保证 T2 阻塞在读锁
        Thread.sleep(100);

        // 中断线程T2，该操作会导致 T2 线程所在 CPU 飙升
        t2.interrupt();
        t2.join();
    }
}
