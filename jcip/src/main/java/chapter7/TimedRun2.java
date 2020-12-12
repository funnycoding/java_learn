package chapter7;

import chapter5.LaunderThrowable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/17 11:52 上午
 */

// Interrupting a task in a dedicated thread 在独立的线程中 中断任务
public class TimedRun2 {
    private static final ScheduledExecutorService cancelExec = Executors.newScheduledThreadPool(1);

    public static void timedRun(final Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
        // 定义一个中断策略
        class RethrowableTask implements Runnable {
            // 定义一个 Throwable 对象，用来传递给调用者
            private volatile Throwable t;

            @Override
            public void run() {
                try {
                    r.run();
                } catch (Throwable t) {
                    this.t = t;
                }
            }

            // 异常重新抛出
            void rethrow() {
                if (t != null) {
                    throw LaunderThrowable.launderThrowable(t);
                }
            }
        }
        RethrowableTask task = new RethrowableTask();
        final Thread taskThread = new Thread(task);
        // 开启任务线程
        taskThread.start();

        // 指定时间后中断任务线程
        cancelExec.schedule(taskThread::interrupt, timeout, unit);

        // 等待工作线程运行超时时间后继续向下执行
        taskThread.join(unit.toMillis(timeout));

        // 重新抛出异常
        task.rethrow();
    }
}
