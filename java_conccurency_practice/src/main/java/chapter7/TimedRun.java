package chapter7;

import chapter5.LaunderThrowable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/17 1:09 下午
 */

// 通过 Future 来取消任务
public class TimedRun {
    private static final ExecutorService taskExec = Executors.newCachedThreadPool();

    public static void timedRun(Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
        // 任务的 Future
        final Future<?> task = taskExec.submit(r);

        try {
            task.get(timeout, unit);
        } catch (TimeoutException e) {
            // 在这里关闭任务
        } catch (ExecutionException e) {
            // 在任务中抛出的异常，在这里重新抛出
            throw LaunderThrowable.launderThrowable(e);
        } finally {
            // 如果任务已经完成，中断任务不会对任务造成影响
            task.cancel(true); // interrupt if running
        }
    }
}
