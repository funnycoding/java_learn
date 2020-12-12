package arrays;

import static arrays.ArrayShow.show;

import java.util.Arrays;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/7 8:00 下午
 */
// FillingArrays.java
public class FillingArrays {
    public static void main(String[] args) {
        int size = 6;
        // 每个类型都创建一个空的数组
        boolean[] a1 = new boolean[size];
        byte[] a2 = new byte[size];
        char[] a3 = new char[size];
        short[] a4 = new short[size];
        int[] a5 = new int[size];
        long[] a6 = new long[size];
        float[] a7 = new float[size];
        double[] a8 = new double[size];
        String[] a9 = new String[size];

        Arrays.fill(a1, true);
        show(a1);
        Arrays.fill(a2, (byte)11);
        show("a2", a2);
        Arrays.fill(a3, 'x');
        show("a3", a3);
        Arrays.fill(a4, (short)17);
        show("a4", a4);
        Arrays.fill(a5, 19);
        show("a5", a5);
        Arrays.fill(a6, 23);
        show("a6", a6);
        Arrays.fill(a7, 29);
        show("a7", a7);
        Arrays.fill(a8, 47);
        show("a8", a8);
        Arrays.fill(a9, "Hello");
        show("a9", a9);
        // Manipulating ranges:
        Arrays.fill(a9, 3, 5, "World");
        show("a9", a9);
    }
}
