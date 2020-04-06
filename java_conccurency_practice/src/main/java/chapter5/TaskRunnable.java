package chapter5;

import java.util.concurrent.BlockingQueue;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/6 8:10 下午
 */
// Restoring the interrupted status so as not to swallow the interrupt
// 恢复中断状态以避免中断被屏蔽
public class TaskRunnable implements Runnable {

    BlockingQueue<Task> queue;

    @Override
    public void run() {
        try {
            processTask(queue.take());
        } catch (InterruptedException e) {
            // 调用 interrupt 将该线程设置为中断状态
            Thread.currentThread().interrupt();
        }
    }

    // 对Task进行处理的业务逻辑代码
    void processTask(Task task) {
        // 处理 task
    }


    interface Task {
    }
}

