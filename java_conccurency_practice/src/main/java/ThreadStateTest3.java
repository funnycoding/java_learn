/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/7/24 2:51 上午
 */

public class ThreadStateTest3 {
    private static final Object LOCKER = new Object();

    public static void main(String[] args) {
        Runnable waiting = () -> {
            System.out.println("whoWillWait 开始等待2秒钟");
            waitting();
            System.out.println("whoWillWait 等待结束");
        };
        Thread whoWillWait = new Thread(waiting);
        whoWillWait.start();
        // 主线程睡眠，让 whoWillWait 获得控制权
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("whoWillWait 线程当前状态：" + whoWillWait.getState());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("whoWillWait当前的线程状态=" + whoWillWait.getState());
        System.exit(1);
    }

    private static void waitting() {
        synchronized (LOCKER) {
            try {
                LOCKER.wait(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
