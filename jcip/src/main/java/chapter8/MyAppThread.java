package chapter8;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/5/10 8:05 下午
 */

// 自定义的 Thread 基类

public class MyAppThread extends Thread {
    public static final String DEFAULT_NAME = "MyAppThread";
    public static volatile boolean debugLifecycle = false;
    public static final AtomicInteger created = new AtomicInteger();
    public static final AtomicInteger alive = new AtomicInteger();
    public static final Logger log = Logger.getAnonymousLogger();

    public MyAppThread(Runnable r) {
        this(r, DEFAULT_NAME);
    }

    public MyAppThread(Runnable r, String name) {
        super(r, name + "-" + created.incrementAndGet());
        setUncaughtExceptionHandler((t, e) -> {
            log.log(Level.SEVERE, "UNCAUGHT in thread" + t.getName(), e);
        });
    }

    /**
     * 运行时写入日志
     */
    @Override
    public void run() {
        // Copy debug flag to ensure consistent value throughout
        boolean debug = debugLifecycle;
        if (debug) {
            log.log(Level.FINE, "Created" + getName());
        }
        try {
            alive.incrementAndGet();
            super.run();
        } finally {
            alive.decrementAndGet();
            if (debug) {
                log.log(Level.FINE, "Exiting" + getName());
            }
        }
    }

    public static int getThreadsCreated() {
        return created.get();
    }

    public static int getThreadsAlive() {
        return alive.get();
    }

    public static boolean getDebug() {
        return debugLifecycle;
    }

    public static void setDebug(boolean b) {
        debugLifecycle = b;
    }
}
