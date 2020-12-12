package arrays;

import static arrays.ArrayShow.show;

import java.util.Arrays;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/7 8:17 下午
 */

// SimpleSetAll.java

class Bob {
    final int id;

    Bob(int n) {
        id = n;
    }

    @Override
    public String toString() {
        return "Bob: " + id;
    }
}

public class SimpleSetAll {
    public static final int SZ = 8;
    static int val = 1;

    static char[] chars = "abcdefghijklmnopqrstuvwxyz"
            .toCharArray();

    static char getChar(int n) {
        return chars[n];
    }

    public static void main(String[] args) {
        // 初始化三个长度为 SZ 的数组
        int[] ia = new int[SZ];
        long[] la = new long[SZ];
        double[] da = new double[SZ];
        Arrays.setAll(ia, n -> n); // [1]
        Arrays.setAll(la, n -> n);
        Arrays.setAll(da, n -> n);

        System.out.println(Arrays.toString(ia));
        System.out.println(Arrays.toString(la));
        System.out.println(Arrays.toString(da));

        Arrays.setAll(ia, n -> val++); // [2] 这里是从1开始的 并且是连续的
        Arrays.setAll(la, n -> val++);
        Arrays.setAll(da, n -> val++);

        System.out.println(Arrays.toString(ia));
        System.out.println(Arrays.toString(la));
        System.out.println(Arrays.toString(da));
        Bob[] ba = new Bob[SZ];
        Arrays.setAll(ba, Bob::new); // [3]
        show(ba);

        Character[] ca = new Character[SZ];
        Arrays.setAll(ca, SimpleSetAll::getChar); // [4]
        show(ca);
    }
}
