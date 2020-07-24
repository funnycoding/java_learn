/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/7/24 2:32 上午
 */

public class ThreadStateTest2 {
    private static final Object LOCKER = new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable waitting = () -> {
            System.out.println("whoWillWait 开始等待 whoWillNotify");
            waitting();
            System.out.println("whoWillWait 等到了 whoWillNotify 的唤醒通知");
        };

        // 创建一个线程调用 waiter.wait() 方法，使 whoWillWait 线程进入 WAITTING 状态
        Thread whoWillWait = new Thread(waitting);
        whoWillWait.start();

        // 让主线程睡2秒，此时whoWillWait将获得 CPU 时间分片
        Thread.sleep(2000);

        System.out.println("whoWillWait 当前的线程状态： " + whoWillWait.getState());

        // 此时启动一个线程调用唤醒方法
        Runnable notify = () -> {
            System.out.println("whoWillNotify 即将唤醒 whoWillWait");
            notifying();
        };
        Thread whoWillNotify = new Thread(notify);
        whoWillNotify.start();
        // 继续让主线程睡眠，出让时间片
        Thread.sleep(2000);

        System.out.println("唤醒后的 whoWillWait 线程状态：" + whoWillWait.getState());
        System.exit(1);
    }

    private static void waitting() {
        synchronized (LOCKER) {
            try {
                // 让锁对象去调用 wait 方法
                LOCKER.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void notifying() {
        synchronized (LOCKER) {
            LOCKER.notify();
            System.out.println("whoWillNotify 已经被调用，即将离开同步代码块");
        }
    }
}
