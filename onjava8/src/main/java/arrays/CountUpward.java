package arrays;

import java.util.Arrays;
import java.util.stream.LongStream;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/9 11:29 上午
 */
// CountUpward.java
public class CountUpward {
    static long[] fillCounted(int size) {
        // seed : 从几开始
        return LongStream.iterate(0, i -> i + 1).limit(size).toArray();
    }

    public static void main(String[] args) {
        long[] longs = fillCounted(20);
        System.out.println(Arrays.toString(longs));

    }
}
