package arrays;

import java.util.Arrays;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/7 3:26 下午
 */
// arrays/ThreeDWithNew.java
public class ThreeDWithNew {
    public static void main(String[] args) {
        // 固定长度的三维数组
        int[][][] a = new int[2][2][4];
        System.out.println(Arrays.deepToString(a));
    }
}
