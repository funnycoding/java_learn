/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/7/22 6:40 下午
 */

public class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("子线程：" + Thread.currentThread().getName());
    }

    public enum State {
        // 线程刚被创建，尚未运行
        NEW,
        // 可运行状态，等待被系统调度器调用
        RUNNABLE,
        // 等待获取 监视器锁(monitor lock)进入临界区，或是在 synchronized 块中循环调用了 Object 类的 wait 方法
        BLOCKED,
        // 有三种场景会导致线程处于 WAITING 状态:
        // 1. 调用 Object 的 wait 方法，但没有指定超时时间
        // 2. 调用 Thread 的 join 方法，但没有指定超时时间
        // 3. 调用 LockSupport 的 park 方法
        WAITING,
        //
        TIMED_WAITING,
        // 终止状态，线程执行完毕
        TERMINATED;
    }
}
