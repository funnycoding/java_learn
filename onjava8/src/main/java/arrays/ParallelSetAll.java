package arrays;

import java.util.Arrays;
import onjava.Rand;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/9 11:49 上午
 */
// ParallelSetAll.java
public class ParallelSetAll {
    static final int SIZE = 10_000_0000;

    static void intArray() {
        int[] ia = new int[SIZE];
        Arrays.setAll(ia, new Rand.Pint()::get);
        Arrays.parallelSetAll(ia, new Rand.Pint()::get);
    }

    static void longArray() {
        long[] la = new long[SIZE];
        Arrays.setAll(la, new Rand.Plong()::get);
        Arrays.parallelSetAll(la, new Rand.Plong()::get);

    }

    public static void main(String[] args) {
        intArray();
        longArray();
    }
}
