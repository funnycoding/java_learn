package streams;

import java.util.stream.IntStream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/20 10:59 下午
 */

//Repeat.java
public class Repeat {
    public static void repeat(int n, Runnable action) {
        IntStream.range(0,n).forEach(i -> action.run());
    }

    // 作为对比的传统循环
    public static void repeteWithForeach(int n, Runnable action) {
        for (int i = 0; i < n; i++) {
            action.run();
        }
    }
}
