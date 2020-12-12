/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/7/24 12:37 上午
 */

public class ThreadStateTest {
    private static final boolean LOCK_FLAG = true;

    public static void main(String[] args) {
        Runnable locker = ThreadStateTest::locker;

        Thread whoWillLockOthers = new Thread(locker);
        System.out.println("调用 start 之前的 whoWillLockOthers 的线程状态：" + whoWillLockOthers.getState());
        whoWillLockOthers.start();
        System.out.println("调用 start 之后的 whoWillLockOthers 的线程状态：" + whoWillLockOthers.getState());

        // 主线程睡眠，让子线程开始执行
        try {
            System.out.println("主线程睡眠2S");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("在临界区中的 whoWillLockOthers 的线程状态：" + whoWillLockOthers.getState());
        System.out.println("创建另一个调用 Locker 的线程并启动");
        // 这里因为 locker() 方法是死循环，所以 whoWillLockOthers 一直不会释放锁对象， whoWillBeLockedye 也就一直无法获得锁对象
        Thread whoWillBeLocked = new Thread(locker);
        whoWillBeLocked.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("无法获得监视器锁的  whoWillBeLocked 的状态：" + whoWillBeLocked.getState());
        System.exit(1);
    }

    public static synchronized void locker() {
        do {
        }
        while (LOCK_FLAG);
    }
}
