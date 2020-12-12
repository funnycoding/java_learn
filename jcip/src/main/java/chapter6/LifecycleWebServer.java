package chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/13 10:41 下午
 */

// 支持关闭操作的 Web 服务器
public class LifecycleWebServer {
    private final ExecutorService exec = Executors.newCachedThreadPool();

    // 开始执行任务
    public void start() throws IOException {
        ServerSocket socket = new ServerSocket(80);
        // 只要任务执行框架没有被通知关闭，则一直执行主循环，同时可能因为 ExecutorService 被关闭抛出 拒绝异常，此时需要对异常进行处理
        while (!exec.isShutdown()) {
            try {
                final Socket conn = socket.accept();
                exec.execute(() -> handleRequest(conn));
            } catch (RejectedExecutionException e) {
                if (!exec.isShutdown()) {
                    log("task submission reject", e);
                }
            }

        }
    }

    private void log(String msg, Exception e) {
        Logger.getAnonymousLogger().log(Level.WARNING, msg, e);
    }

    // 这里定义了一个接口，模拟我们自己定义的业务接口
    interface Request {
    }

    // 对连接进行业务处理，首先判断封装的程序是否处于关闭状态，如果是，则调用 ExecutorService 的shutdown() 方法，否则进行任务分发
    void handleRequest(Socket connection) {
        Request req = readRequest(connection);
        if (isShutdownRequest(req)) {
            stop();
        } else {
            dispatchRequest(req);
        }
    }

    private void dispatchRequest(Request req) {
        //...啥也不做
    }

    private void stop() {
        exec.shutdown();
    }

    private boolean isShutdownRequest(Request req) {
        return false;
    }

    private Request readRequest(Socket s) {
        return null;
    }
}
