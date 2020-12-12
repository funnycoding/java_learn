package collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description Set 的一些常见艹做
 * @date 2020/2/16 3:51 下午
 */

public class SetOperations {
    public static void main(String[] args) {
        // 先来个 HashSet 热热身
        Set<String> set1 = new HashSet<>();

        Collections.addAll(set1, "A B C D E F G H I J K L".split(" "));
        set1.add("M");
        // 这俩输出也太基础了
        System.out.println("H " + set1.contains("H"));
        System.out.println("N " + set1.contains("N"));
        // 另一个 Set
        Set<String> set2 = new HashSet<>();
        Collections.addAll(set2, "H I J K L".split(" "));

        // Set2 是否是 Set1 的子集，毫无疑问 可以看到 是的
        System.out.println("set2 in set1: " + set1.containsAll(set2));

        // 当把 Set1 中的 H 元素移除之后， Set2就不是1的子集了
        set1.remove("H");
        System.out.println("set1: " + set1);
        System.out.println("set2 in set1: " + set1.containsAll(set2));

        // 这应该是把 移除所有 在 Set1 中 1和2的交集元素
        set1.removeAll(set2);
        System.out.println("set2 removed from set1: " + set1);

        // 给 Set1 添加 XYZ 元素
        Collections.addAll(set1, "X Y Z".split(" "));
        System.out.println("'X Y Z' added to set1: " + set1);
    }
}
