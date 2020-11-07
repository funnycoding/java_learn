package alograthim;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/9/23 8:18 下午
 */

/*
public class Demo {
    */
/**
     * 分析：数据规模是不确定的所以不能忽略，而是要相加 首先要循环 n 次，所以 O(n)
     * 另外循环进行判断 pos == x 最好情况是第一次就找到，最坏是最后找到，也就是又循环了 n 次
     * O(1) ~ O(n) ，按最坏来 O(n+n) O(2n) 忽略常数 O(n)
     *//*

    int find(int[] array, int n, int x) {
        int i = 0;
        int pos = -1;
        for (; i < n; ++i) {
            if (array[i] == x) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    // array 代表一个长度为 n 的数组， 方法中的 array.lenght 就是数据规模 n
    int[] array = new int[n];
    int count = 0;

    void insert(int val) {
        if (count == array.length) {
            int sum = 0;
            for (int i = 0; i < array.length; ++i) {
                sum = sum + array[i];
            }
            array[0] = sum;
            count = 1;
        }
        array[count] = val;
        ++count;
    }
}
*/
