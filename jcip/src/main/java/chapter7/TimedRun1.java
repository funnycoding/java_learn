package chapter7;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/17 11:33 上午
 */
// Scheduling an interrupt on a borrowed thread （不要这么做）
public class TimedRun1 {
    private static final ScheduledExecutorService cancelExec = Executors.newScheduledThreadPool(1);

    public static void timedRun(Runnable r, long timeout, TimeUnit unit) {
        // 任务线程
        final Thread taskThread = Thread.currentThread();
        // 在指定时间后调用 任务线程的 interrupt 方法
        cancelExec.schedule(taskThread::interrupt, timeout, unit);
    }
}
