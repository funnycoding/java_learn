package chapter3;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

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

    public static void main(String[] args) throws IOException, InterruptedException {
      /*  final ServerSocketChannel ssc = ServerSocketChannel.open()
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
        }*/

       /*
        ExecutorService es = Executors.newFixedThreadPool(500);

        final ServerSocketChannel ssc = ServerSocketChannel.open()
                .bind(new InetSocketAddress(8080));

        // 处理请求
        try {
            while (true) {
                // 接受请求
                SocketChannel sc = ssc.accept();
                // 将需要处理的任务提交给线程池
                es.execute(()->{
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
                    } catch (IOException e) {
                        throw new UncheckedIOException(e);
                    }

                });
            }
        }finally {
            ssc.close();
            es.shutdown();
        }*/


        // 实际工作中建议使用有界队列的线程池
/*        ExecutorService es = new ThreadPoolExecutor(50,
                500,
                60L,
                TimeUnit.SECONDS,
                // 上限2000的有界队列
                new LinkedBlockingDeque<>(2000),
                // 建议根据业务需求实现 ThreadFactory
                r -> {
                    return new Thread(r, "echo-" + r.hashCode());
                },
                new CallerRunsPolicy() // 拒绝策略
        );*/

        // L1,L2 阶段共用的线程池
        ExecutorService es = Executors.newFixedThreadPool(2);

        // L1阶段的闭锁
        CountDownLatch l1 = new CountDownLatch(2);

        for (int i = 0; i < 2; i++) {
            System.out.println("L1");
            // 执行L1 阶段任务
            es.execute(()-> {
                // L2 阶段的闭锁
                CountDownLatch l2 = new CountDownLatch(2);

                // 执行L2阶段的子任务
                for (int j = 0; j < 2; j++) {
                    es.execute(()->{
                        System.out.println("L2");
                        l2.countDown();
                    });
                }
                // 等待L2阶段任务执行完成
                try {
                    l2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                l1.countDown();
            });
        }
        // 等待L1阶段任务执行完成
        l1.await();
        System.out.println("end");
    }
}
