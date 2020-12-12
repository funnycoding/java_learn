package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/15 3:53 下午
 */



public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(collection);
        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));
        // 此时collection 已经包含原有元素和 moreInts 数组的所有元素
        System.out.println(collection);

        // Runs significantly faster, but you can't
        // construct a Collection this way:
        // 这样更快，但是不能使用这种方式构建 Collection

        Collections.addAll(collection, 11, 12, 13, 14, 15);
        System.out.println(collection);
        Collections.addAll(collection, moreInts);
        System.out.println(collection);

        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        System.out.println("list: " + list);
        list.set(1, 99);  // OK -- modify an element 是把第一个元素改成了99了吗?
        System.out.println("list change 1 as 99 : " + list);
    }

}
