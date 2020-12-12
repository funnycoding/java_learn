package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/17 1:25 上午
 */

public class ModifyingArrayList {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Integer[] ia = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list1 = new ArrayList<>(Arrays.asList(ia));
        System.out.println("Before Shuffling "+list1);
        // 打乱数组
        Collections.shuffle(list1, rand);
        System.out.println("After shuffling: " + list1);
        System.out.println("array " + Arrays.toString(ia) ); // 可以看到底层数组并没有被修改

        List<Integer> list2 = Arrays.asList(ia);
        System.out.println("Before shuffling: " + list2);
        Collections.shuffle(list2, rand);
        System.out.println("After shuffling: " + list2);
        System.out.println("array: " + Arrays.toString(ia));
    }
}
