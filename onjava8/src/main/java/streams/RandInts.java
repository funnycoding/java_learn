package streams;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/22 5:28 下午
 */
// RandInts.java
public class RandInts {
    private static int[] randomInts = new Random(47)
            .ints(0, 1000)
            .limit(100)
            .toArray();

    public static IntStream rands() {
        return Arrays.stream(randomInts);
    }
}
