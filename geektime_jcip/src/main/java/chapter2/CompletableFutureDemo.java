package chapter2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomUtils;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/8/13 12:58 下午
 */

public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture<Integer> f0 = CompletableFuture
                .supplyAsync(() -> 7 / 0)
                .thenApply(r -> r * 10)
                .exceptionally(e -> 0);
        System.out.println(f0.join());

    /*    CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            int t = RandomUtils.nextInt(5, 10);
            sleep(t, TimeUnit.SECONDS);
            return String.valueOf(t);
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            int t = RandomUtils.nextInt(5, 10);
            sleep(t, TimeUnit.SECONDS);
            return String.valueOf(t);
        });

        CompletableFuture<String> f3 = f1.applyToEither(f2, s -> s);

        System.out.println(f3.join());*/

 /*       CompletableFuture<String> f0 = CompletableFuture.supplyAsync(() -> "Hello Word")    // ①
                .thenApply(s -> s + " QQ") // ②
                .thenApply(String::toUpperCase); // ③

        System.out.println(f0.join());*/


      /*

        // 任务1 ：洗水壶->烧开水
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            System.out.println("T1 洗水壶");
            sleep(1, TimeUnit.SECONDS);
            System.out.println("T1 烧开水");
            sleep(15, TimeUnit.SECONDS);
        });

        // 任务2：洗茶壶——洗茶杯——放茶叶
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("T2 洗茶壶");
            sleep(1, TimeUnit.SECONDS);

            System.out.println("T2 洗茶杯");
            sleep(1, TimeUnit.SECONDS);

            System.out.println("T2 拿茶叶");
            sleep(1, TimeUnit.SECONDS);

            return "龙井";
        });

        // 任务3：等待任务2和任务1执行完成后才执行：泡茶
        CompletableFuture<String> f3 = f1.thenCombine(f2, (__, tf) -> {
            System.out.println("T1 拿到茶叶" + tf);
            System.out.println("T1 泡茶");
            return "上茶" + tf;
        });
        // 主线程等待 任务3执行完成
        System.out.println(f3.join());*/
    }


    static void sleep(int t, TimeUnit unit) {
        try {
            unit.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
