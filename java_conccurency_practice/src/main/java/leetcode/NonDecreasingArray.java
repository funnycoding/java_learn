package leetcode;

import chapter2.CountingFactorizer;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description 非递减数列
 * @date 2020/6/23 1:14 下午
 */

public class NonDecreasingArray {
    /**
     * 思路：
     * 1. 遍历数组，找出 i>i+1 的次数，大于1则返回 false，小于等于1 返回 true
     *
     * @param nums
     * @return
     */
    private static boolean checkPossibility(int[] nums) {
        // 边界条件
        if (nums == null || nums.length <= 1) {
            return true;
        }

        // 记录次数
        int count = 0;

        for (int i = 1; i <nums.length && count < 2 ; i++) {
            // 前一个元素 <= 现在的元素
            if (nums[i - 1] <= nums[i]) {
                continue;
            }
            count++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        //int[] i = {-1,4, 2, 3};
        //int[] i = {3, 4, 2, 3};
        int[] i = {1,3,5,2,4};
        boolean b = checkPossibility(i);
        System.out.println(b);
    }
}
