package chapter2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/8/12 5:02 下午
 */

public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建T2线程的FutureTask
        FutureTask<String> ft2 = new FutureTask<>(new T2Task());

        // 创建T1线程的FutureTask
        FutureTask<String> ft1 = new FutureTask<>(new T1Task(ft2));

        // 线程T1 执行任务 ft1
        Thread T1 = new Thread(ft1);
        T1.start();

        // 线程T2执行任务ft2
        Thread T2 = new Thread(ft2);
        T2.start();

        // 等待线程T1的执行结果
        System.out.println(ft1.get());


    }

    // T1Task 需要执行的任务：洗水壶、烧开水、泡茶
    private static class T1Task implements Callable<String> {
        FutureTask<String> ft2;

        //T1 任务需要 T2任务的 FutureTask
        T1Task(FutureTask<String> ft2) {
            this.ft2 = ft2;
        }



        @Override
        public String call() throws Exception {
            System.out.println("T1 洗水壶");
            TimeUnit.SECONDS.sleep(1);

            System.out.println("T1 烧开水");
            TimeUnit.SECONDS.sleep(15);

            //获取 T2 线程的插页
            String tf = ft2.get();
            System.out.println("T1 拿到茶叶" + tf);

            System.out.println("T1 开始泡茶");
            return "上茶" + tf;
        }
    }

    // T2Task 需要执行的任务：洗茶壶、洗茶杯、放茶叶
    private static class T2Task implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("T2 洗茶壶");

            TimeUnit.SECONDS.sleep(1);

            System.out.println("T2 洗茶杯");
            TimeUnit.SECONDS.sleep(2);

            System.out.println("T2 拿茶叶");
            TimeUnit.SECONDS.sleep(1);

            return "龙井";
        }
    }
}
