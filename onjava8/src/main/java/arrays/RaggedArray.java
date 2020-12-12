package arrays;

import java.util.Arrays;
import java.util.SplittableRandom;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/7 4:46 下午
 */

// RaggedArray.java
public class RaggedArray {
    static int val = 1;
    public static void main(String[] args) {
        SplittableRandom rand = new SplittableRandom(47);
        // 初始化一个动态长度的三维数组
        int i1 = rand.nextInt(7);
        System.out.println("i1: " + i1);
        int[][][] a = new int[i1][][];
        for (int i = 0; i < a.length; i++) {
            int i2 = rand.nextInt(5);
            System.out.println("i2: " + i2);
            a[i] = new int[i2][];
            for (int j = 0; j < a[i].length; j++) {
                int i3 = rand.nextInt(5);
                System.out.println("i3: " + i3);
                a[i][j] = new int[i3];
                Arrays.setAll(a[i][j], n -> val++); // 填充这个数组的内容
            }
        }
        System.out.println(Arrays.deepToString(a)); // 打印这个数组
    }
}
