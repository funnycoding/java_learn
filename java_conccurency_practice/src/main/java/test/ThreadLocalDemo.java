package test;

import java.util.concurrent.CountDownLatch;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/5/26 6:37 下午
 */

public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        int threads = 3;
        //todo 复习 CountDownLatch
        CountDownLatch countDownLatch = new CountDownLatch(threads);

        InnerClass innerClass = new InnerClass();

        for (int i = 1; i <= threads ; i++) {
            // 每个循环创建一个线程，每个线程添加 0-3 这4个数字
            new Thread(() -> {
                for (int j = 0; j < 4; j++) {
                    innerClass.add(String.valueOf(j));
                    innerClass.print();
                }
                innerClass.set("hello world");
                countDownLatch.countDown();
            }, "thread- " + i).start();
        }
        //todo 这句是干嘛的？
        countDownLatch.await();
    }

    private static class InnerClass {
        public void add(String newStr) {
            // 获取一个 StringBuilder
            StringBuilder str = Counter.counter.get();
            // 拼接入参后存入 ThreadLocal
            Counter.counter.set(str.append(newStr));
        }

        public void print() {
            System.out.printf("ThreadName:%s, "
                            + "ThreadLocal hashCode : %s, "
                            + "Instance hashCode :%s , "
                            + "Value:%s \n",
                    Thread.currentThread().getName(),
                    Counter.counter.hashCode(),
                    Counter.counter.get().hashCode(),
                    Counter.counter.get().toString()
            );
        }

        public void set(String words) {
            Counter.counter.set(new StringBuilder(words));
            System.out
                    .printf("Set, Thread name:%s , ThreadLocal hashcode:%s,  Instance hashcode:%s, Value:%s\n",
                            Thread.currentThread().getName(),
                            Counter.counter.hashCode(),
                            Counter.counter.get().hashCode(),
                            Counter.counter.get().toString());
        }
    }

    private static class Counter {
        private static ThreadLocal<StringBuilder> counter = ThreadLocal
                .withInitial(() -> new StringBuilder());
    }

}
