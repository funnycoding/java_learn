package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/6/25 10:52 上午
 */

public class LeetCode {

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
        double ans = 0;
        int len = salary.length;

        Arrays.sort(salary);
        for (int i = 1; i < len - 1; i++) {
            ans += salary[i];
        }
        return ans / (len - 2);
    }

    /**
     * 287 移动零 <br/>
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * ------------------
     * 说明:
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * ------------------
     * 思路：
     * 遍历一次数组，对元素进行判断 如果该元素是0，则将其余元素 index+1 ，将该元素置为数组尾部
     *
     * 疑问：
     * 1. 需要继续明确条件，该数组本身是否是有序的？
     *
     * 2. 对数组进行索引的移动是否很消耗性能
     * -------------------
     * 边界条件：如果数组传入是空？
     *
     * @param nums 目标数组
     */
    public static void moveZeroes(int[] nums) {
        // 边界条件判断，如果数组为空，直接返回
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            // 如果元素是0，则进入判断条件，找到该元素之后第一个非0的元素，将当前索引元素与非0元素交换
            if (nums[i] == 0) {
                // 如果下个元素不是0，则正常处理 直接交换就行了，将最后一位赋值为0
                if (nums[i + 1] != 0) {
                    // 核心操作：将该元素之后的元素向左移一位，将末尾元素置为0
                    for (int j = i; j < nums.length - 1; j++) {
                        nums[j] = nums[j + 1];
                    }
                    nums[nums.length - 1] = 0;
                } else {
                    // 如果下个元素还是0，则开始判断到下个非0元素之间的元素数量
                    int zeroElementNums = 1; // 元素为0的数量
                    // 从这开始循环 找出下一个非0元素的值，
                    for (int j = i + 1; j < nums.length - 1; j++) {
                        if (j <= nums.length - 1 && nums[j] == 0) {
                            zeroElementNums++;
                        } else {
                            // 注意，这里需要跳出的是外层循环，否则会继续 for 循环，程序出错
                            break;
                        }
                    }
                    if (i + zeroElementNums <= nums.length - 1) {
                        int noneZeroElementIndex = i + zeroElementNums;
                        // 将第一个非0元素赋值给当前为0的元素
                        nums[i] = nums[noneZeroElementIndex];
                        nums[noneZeroElementIndex] = 0;
                        // 将第一个非0元素之后的元素向前移动一位
                        for (int j = noneZeroElementIndex; j < nums.length - 1; j++) {
                            nums[j] = nums[j + 1];
                        }
                        // 末尾置为0
                        nums[nums.length - 1] = 0;
                    }
                }
            }
        }
    }

    /**
     * 287 移动零 <br/>
     * 优秀解
     *
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        // 边界排除
        if (nums == null || nums.length <= 1) {
            return;
        }
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }

    /**
     * 566. 重塑矩阵
     *
     * @param nums 二维数组
     * @param r 重构后矩阵的 行数
     * @param c 重构后矩阵的 列数
     * @return 如果可以重构，返回重构后的矩阵，如果不可用，返回原矩阵
     *
     * 1、 先根据传入数组的 行 跟 列 算出 是否支持重构
     * 2、 如果不支持，返回原数组，如果支持，重新根据 r 和 构建一个数组，并进行填充
     * --- 2展开，遍历填充数组还是直接使用 API 进行元素的复制？
     * 边界：
     * 1. 数组 宽和高在 1 - 100
     * 2. r 和 c 都是正数
     *
     * 这里我第一遍写的时候存在的问题：
     * 1. 没有判断数组长度等于0
     * 2. 应该是元素数不相等，而我认为的是只要原始数组的元素数大于新数组即可（如果大于也是无法重塑的）
     * 3. 卡在了重塑这一步具体的步骤上
     */
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        // 2. 如果可以，则先创建一个新的数组
        int[][] newNums = new int[r][c];

        // 1.判定是否可以重塑，如果不可以，则直接返回
        if (nums.length == 0 || nums.length * nums[0].length != r * c) {
            return nums;
        }
        // 解法1 使用队列放置提取的元素，取出以串行顺序形成的队列元素，再按逐行排列所得到的矩阵中的元素
        Queue<Integer> queue = new LinkedList<>();

        // 遍历原矩阵，将其中的所有元素放入队列中
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                queue.add(nums[i][j]);
            }
        }

        // 将队列中的元素放入新数组
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newNums[i][j] = queue.remove();
            }
        }

        return newNums;
    }


    /**
     * 485 最大连续1的个数
     * 思路：遍历，用一个变量保存连续1的个数即可
     *
     * @param nums 数组
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        boolean isOne = false;
        // 边界确认
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                maxCount = Math.max(count, maxCount);
                count = 0;
            }
        }
        maxCount = Math.max(count, maxCount);
        return maxCount;
    }

    /**
     * 2020-08-15 23:51:10
     * LeetCode-Array-medium-240-搜索二维矩阵
     * 给定一个二维矩阵，给定一个要搜索的值，返回该矩阵是否包含该值
     *
     * @param matrix 给定矩阵
     * @param target 查找值
     * @return 查找值是否在矩阵中存在
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        // 边界确认
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        // 1. 遍历数组比对target
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 使用二分法查找矩阵中的元素
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrixBinary(int[][] matrix, int target) {
        // 边界确认
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        // 遍历数组的对角线
        int shortDim = Math.min(matrix.length, matrix[0].length); // 返回行和列更小的那个

        for (int i = 0; i < shortDim; i++) {
            // 竖排查找
            boolean verticalFound = binarySearch(matrix, target, i, true);

            // 横排查找
            boolean horizontalFound = binarySearch(matrix, target, i, false);

            if (verticalFound || horizontalFound) {
                return true;
            }
        }
        return false;
    }


    /**
     * @param martrix 给定矩阵
     * @param target 要查找的元素
     * @param start 起始元素
     * @param vertical 是竖直还是水平搜索
     * @return 元素是否存在
     */
    private static boolean binarySearch(int[][] martrix, int target, int start, boolean vertical) {
        int lo = start;
        // 如果是竖直的，就获取竖直数组的最后一个元素，否则获取水平数组的最后一个元素
        int hi = vertical ? martrix[0].length - 1 : martrix.length - 1;

        while (hi >= lo) {
            // 找到中间元素
            int mid = (lo + hi) / 2;
            // 针对列查找
            if (vertical) {
                // 如果中间元素比目标元素小，最低值向右移动一位
                if (martrix[start][mid] < target) {
                    lo = mid + 1;
                    // 如果中间元素比目标值大，最高值向左移动1位
                } else if (martrix[start][mid] > target) {
                    hi = mid - 1;
                } else {
                    // 这是直接相等的情况了
                    return true;
                }
            } else { // 查找的是 行
                if (martrix[mid][start] < target) {
                    lo = mid + 1;
                } else if (martrix[mid][start] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 378 有序矩阵中第 K 小的元素
     *
     * @param matrix 给定的 n x n 的矩阵，每行和每列的元素按顺序排序 找到矩阵中 第 k 小的元素
     * 注意点： 这个 k 是排序后 第 k 小的元素，不是 第 k 个不同的元素（第一遍看的时候不太理解
     * 示例：
     * matrix = [
     * [ 1,  5,  9],
     * [10, 11, 13],
     * [12, 13, 15]
     * ],
     * k = 8,
     *
     * 返回 13。
     * 提示： 可以假设 k 的值永远是有效的 1 <= k <= n 的平方
     *
     * 下面先来个无脑暴力法(照着抄的）
     * @param k 要找到第 k 小的元素
     * @return
     */
    public static int kthSmallest(int[][] matrix, int k) {
        // 定义n是为了定位最后一个元素
        int n = matrix.length - 1;
        // 定位到第一个元素和最后一个元素，因为矩阵是有序的，下面开始二分
        int l = matrix[0][0], r = matrix[n][n];
        while (l < r) {
            int mid = l + (r - l) / 2; // 选定一个中间元素
            int count = countNoMoreThanMid(matrix, mid, n);
            if (count < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    private static int countNoMoreThanMid(int[][] matrix, int mid, int n) {
        int x = n, y = 0, count = 0;
        while (x >= 0 && y <= n) {
            if (matrix[x][y] <= mid) {
                count += x + 1;
                ++y;
            } else {
                --x;
            }
        }
        return count;
    }

    /**
     * 测试函数
     *
     * @param args
     */
    public static void main(String[] args) {

        //88
     /*   int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        merge(nums1, m, nums2, n);*/

        //1160
      /*  String chara = "ababac";
        countCharacters(null, chara);*/
        // 1491
   /*     int[] salary = {48000, 59000, 99000, 13000, 78000, 45000, 31000, 17000, 39000, 37000, 93000,
                77000, 33000, 28000, 4000, 54000, 67000, 6000, 1000, 11000};
        average(salary);*/

        // 283
       /* int[] test283 = {0, 1, 0, 3, 12};
        int[] test284 = {-370741595,
                0,
                0,
                -2109519986,
                0,
                0,
                -70546121,
                -122624749,
                -1199903092};
        int[] test283 = {0, 1, 0, 3, 12};
        moveZeroes(test283);
        moveZeroes2(test283);
        System.out.println(Arrays.toString(test283));*/

        //566
/*        int[][] arr = {{1, 2}, {3, 4}};

        matrixReshape(arr, 1, 4);*/
        // ----------------485----------------
     /*   int[] arr = {1, 1, 0, 1, 1, 1};
        System.out.println( findMaxConsecutiveOnes(arr));*/
        // ----------------485----------------
/*        int[][] arr = {{1, 2}, {3, 4}};
        System.out.println(searchMatrixBinary(arr, 5));*/

        // 378
        int[][] arr = {{1, 5,9}, {10, 11,13},{12,13,15}};
        System.out.println(kthSmallest(arr, 8));
    }

}
