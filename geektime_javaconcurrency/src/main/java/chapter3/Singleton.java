package chapter3;

import co.paralleluniverse.fibers.Fiber;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.LockSupport;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/8/19 10:27 下午
 */

public class Singleton {
    private static Singleton singleton;

    // 私有化构造函数
    private Singleton() {

    }

    // 单例的获取 Singleton 实例的方法
    public static Singleton getInstance() {
        // 第一次检查
        if (singleton == null) {
            synchronized (Singleton.class) {
                // 获取锁后的二次检查
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) throws IOException {
        final ServerSocketChannel ssc = ServerSocketChannel.open()
                .bind(new InetSocketAddress(8080));

        // 处理请求
        try {
            while (true) {
                // 接受请求
                SocketChannel sc = ssc.accept();
                // 这里使用 Fiber.schedule 创建一个协程
                Fiber.schedule(() -> {
                    try {
                        // 读 Socket
                        ByteBuffer rb = ByteBuffer.allocate(1024);
                        sc.read(rb);
                        // 模拟处理请求
                        LockSupport.parkNanos(2000 * 1000000);
                        // 写 Socket
                        ByteBuffer wb = (ByteBuffer) rb.flip();
                        sc.write(wb);
                        sc.close();
                    } catch (Exception e) {
                        throw new UncheckedIOException(e);
                    }
                }).start();
            }
        }finally {
            ssc.close();
        }



    }
}
