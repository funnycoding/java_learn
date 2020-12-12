package chapter7;

import java.util.concurrent.BlockingQueue;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/17 11:15 上午
 */

// 不可取消的任务在退出前恢复中断
public class NoncancelableTask {
    public Task getNextTask(BlockingQueue<Task> queue) {
        boolean interrupted = false;
        try {
            while (true) {
                return queue.take();
            }
        } catch (InterruptedException e) {
            // 如果被中断，则将中断标志设置为 True
            interrupted = true;
            // fall through and retry 异常抛出和重试
        } finally {
            // 最终会根据 interrupted 标志位 去恢复线程的中断状态
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
        return null;
    }

    interface Task {
    }
}
