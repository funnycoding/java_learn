package arrays;

import java.util.Arrays;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/9 9:15 下午
 */

public class ParallelPrefix3 {
    static final int SIZE = 10_000_000;

    public static void main(String[] args) {
        long[] nums = new long[SIZE];
        Arrays.setAll(nums,n -> n);
        Arrays.parallelPrefix(nums, Long::sum);
        System.out.println("First 20: " + nums[19]);
        System.out.println("First 200: " + nums[199]);
        System.out.println("All: " + nums[nums.length - 1]);
    }
}
