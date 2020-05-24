package chapter8;

import java.util.concurrent.ThreadFactory;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/5/10 8:00 下午
 */
// 自定义的线程工厂
public class MyThreadFactory implements ThreadFactory {
    private final String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new MyAppThread(r, poolName);
    }
}
