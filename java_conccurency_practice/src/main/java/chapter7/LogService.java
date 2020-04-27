package chapter7;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import net.jcip.annotations.GuardedBy;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/21 11:16 上午
 */

// 存在可靠的取消服务的 LogWriter 类
public class LogService {
    private final BlockingQueue<String> queue;
    private final LoggerThread loggerThred;
    private final PrintWriter writer;

    @GuardedBy("this")
    private boolean isShutdown;
    @GuardedBy("this")
    private int reservations;

    public LogService(PrintWriter writer) {
        this.queue = new LinkedBlockingQueue<>();
        this.loggerThred = new LoggerThread();
        this.writer = new PrintWriter(writer);
    }

    public void start() {
        loggerThred.start();
    }

    /**
     * 关闭服务的方法,将中断标志设为true，并且申请中断该线程
     */
    public void stop() {
        synchronized (this) {
            isShutdown = true;
        }
        // 中断该线程
        loggerThred.interrupt();
    }

    /**
     * 产生 log 信息的方法，当服务被终止时 调用该方法抛出异常
     *
     * @param msg 日志信息
     * @throws InterruptedException
     */
    public void log(String msg) throws InterruptedException {
        synchronized (this) {
            if (isShutdown) {
                throw new IllegalStateException("线程已被终止");
            }
            // 工作队列中待处理信息的数量
            ++reservations;
        }
        queue.put(msg);
    }

    // 写入日志的工作线程
    private class LoggerThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    try {
                        synchronized (LogService.this) {
                            if (isShutdown && reservations == 0) {
                                break;
                            }
                        }
                        final String msg = queue.take();
                        synchronized (LogService.this) {
                            --reservations;
                        }
                        // 写入数据
                        writer.println(msg);
                    } catch (InterruptedException e) {
                        // 重试
                    }
                }
            } finally {
                writer.close();
            }
        }
    }
}
