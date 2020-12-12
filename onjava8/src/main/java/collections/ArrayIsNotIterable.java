package collections;

import java.util.Arrays;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/16 11:43 下午
 */

public class ArrayIsNotIterable {
    // 打印迭代器元素
    static <T> void test(Iterable<T> ib) {
        for (T t : ib) {
            System.out.print(t + " ");
        }
    }

    public static void main(String[] args) {
        test(Arrays.asList(1,2,3));
        String[] strs = {"A", "B", "C"};
      

        test(Arrays.asList(strs));

    }


}
