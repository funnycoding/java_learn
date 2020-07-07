package leetcode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/6/25 10:52 上午
 */

public class LeetCode {
    public static void main(String[] args) {
        //int[] i = {1, 3, 5, 4, 2, 3, 4, 5};
        //System.out.println(findLengthOfLCIS(i));

        //int[] i = {0,1,1,1,2,3};
        //int[] i = {1, 1, 2};
        //System.out.println(removeDuplicates(i));
        //System.out.println(Arrays.toString(i));

        //88
        //int[] nums1 = {1, 2, 3, 0, 0, 0};
        //int[] nums2 = {2, 5, 6};
        //int m = 3;
        //int n = 3;
        //merge(nums1, m, nums2, n);

        //1160
      /*  String chara = "ababac";
        countCharacters(null, chara);*/
        // 1491
        int[] salary = {48000, 59000, 99000, 13000, 78000, 45000, 31000, 17000, 39000, 37000, 93000,
                77000, 33000, 28000, 4000, 54000, 67000, 6000, 1000, 11000};
        average(salary);
    }

    // 674-最长连续递增序列
    public static int findLengthOfLCIS(int[] nums) {
        // 边界判定
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int lastCount = 1;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
            } else {
                if (count > lastCount) {
                    lastCount = count;
                }
                count = 1;
            }
        }
        return Math.max(lastCount, count);
    }


    //26 删除排序数组中的重复项
    //核心：
    // 1. 去重
    // 2.空间复杂度 O(1)
    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }

        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }

        return i + 1;
    }

    /**
     * 88. 合并两个有序的数组 ，将 nums2 合并到 nums1 中，使其成为一个有序数组，nums1 和 nums2 都是有序的
     *
     * @param nums1 合并 dest
     * @param m nums1 的长度  nums1.length >= m+n 要遍历的次数
     * @param nums2 合并 source
     * @param n nums2 的长度
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }


    /**
     * 1160 拼写单词
     * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
     *
     * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
     *
     * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
     *
     * 返回词汇表 words 中你掌握的所有单词的 长度之和。
     *
     * 思路：使用 hashmap 存储 字幕表中每个字幕对应出现的次数，然后和词汇表中做对比，能完全对应上的，则视为可拼写
     *
     * @param words
     * @param chars
     * @return
     */
    public static int countCharacters(String[] words, String chars) {
        int length = 0;
        HashMap<Character, Integer> charNums = new HashMap<>();
        // 1. 将 chars 打散为 char[]
        char[] charsArrays = chars.toCharArray();
        for (int i = 0; i < charsArrays.length; i++) {
            char singleChar = charsArrays[i];
            Integer times = charNums.get(singleChar);
            if (times != null) {
                charNums.put(singleChar, ++times);
            } else {
                // 第一次出现
                charNums.put(singleChar, 1);
            }
        }
        HashMap<Character, Integer> temp;
        for (String word : words) {
            boolean flag = true;
            temp = new HashMap<>();
            char[] wordsCharArr = word.toCharArray();
            for (char c : wordsCharArr) {
                int count = temp.getOrDefault(c, 0) + 1;
                if (count > charNums.getOrDefault(c, 0)) {
                    flag = false;
                    break;
                }
                temp.put(c, count);
            }
            if (flag) {
                length += word.length();
            }
        }
        return length;
    }

    /**
     * 1491. 去掉最低工资和最高工资后的平均值
     * 关键点：
     * 1： 【3 <= salary.length <= 100】 -》 数组长度
     * 2：【10^3 <= salary[i] <= 10^6】 元素大小
     * 3： 元素唯一
     * 4：误差值小于 【10 ^ -5】
     * 思路：
     * 一个存最大值，一个存最小值
     *
     * @param salary
     * @return
     */
    public static double average(int[] salary) {
        double ans=0;
        int len=salary.length;

        Arrays.sort(salary);
        for(int i=1;i<len-1;i++){
            ans+=salary[i];
        }
        return ans/(len-2);
    }
}
