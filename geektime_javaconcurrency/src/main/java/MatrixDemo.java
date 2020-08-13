import java.util.Arrays;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description 创建一个二维数组作为矩阵
 * @date 2020/8/12 9:33 下午
 */

public class MatrixDemo {
    // 二维数组 前一个是行 后一个是列
    public static void main(String[] args) {
        int[] arr2 = {1, 2};
        // 创建一个二维数组
        int[][] arr = new int[4][6];
        arr[1][2] = 1;
        System.out.println(Arrays.toString(arr[1]));

        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }
}
