package chapter6;

import java.util.concurrent.Executor;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/13 9:44 下午
 */

// 让线程池以单线程的串行形式执行任务
public class WithinThreadExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
