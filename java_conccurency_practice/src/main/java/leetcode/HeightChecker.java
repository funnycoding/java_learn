package leetcode;

import java.util.Arrays;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description 数组——1051 高度检查器
 * @date 2020/6/24 5:12 下午
 */

public class HeightChecker {
    /**
     * 使用了 Arrays.sort 快排算法，然后对数组进行遍历并将原数组与排序后的数组进行比较
     *
     * @param heights
     * @return
     */
    public int check(int[] heights) {
        int count = 0;
        // 对原数组的副本进行排序
        int[] temp = heights.clone();
        Arrays.sort(temp);
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != temp[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] i = {1, 2, 3};
        System.out.println(i.length-1);
    }

}
