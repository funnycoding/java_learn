package arrays;

import java.util.Arrays;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/7 5:18 下午
 */
//AssemblingMultidimensionalArrays.java
public class AssemblingMultidimensionalArrays {
    public static void main(String[] args) {
        Integer[][] a;
        a = new Integer[3][];

        for (int i = 0; i < a.length; i++) {
            a[i] = new Integer[3];
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = i * j; // 自动装箱
            }
        }
        System.out.println(Arrays.deepToString(a));
    }
}
