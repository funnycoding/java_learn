package arrays;

import java.util.Arrays;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/7 3:22 下午
 */
// arrays/MultidimensionalPrimitiveArray.java

public class MultidimensionalPrimitiveArray {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6}
        };
        // 打印多维数组
        System.out.println(Arrays.deepToString(a));
    }
}
