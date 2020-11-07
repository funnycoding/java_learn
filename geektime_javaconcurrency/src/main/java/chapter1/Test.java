package chapter1;


import java.util.concurrent.atomic.AtomicLong;
import lombok.extern.slf4j.Slf4j;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/9 2:15 下午
 */

@Slf4j
public class Test {
    private static AtomicLong atomicCount = new AtomicLong(0);
    private long count = 0;

    private   void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
            atomicCount.incrementAndGet();
        }
    }

    public static long calc() throws InterruptedException {
        final Test test = new Test();
        // 创建两个线程，执行 add10K 方法
        Thread th1 = new Thread(test::add10K);
        Thread th2 = new Thread(test::add10K);

        // 启动 th1,th2 线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束 th1.join(); th2.join();
        th1.join();
        th2.join();
        return test.count;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            long calc = Test.calc();
            log.info("本次 count 结果{}",calc);
            log.info("本次原子类返回结果{}",atomicCount.longValue());
            System.out.println("\r\n");
            atomicCount = new AtomicLong(0);
        }
    }
}


