// onjava/CollectionMethodDifferences.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java onjava.CollectionMethodDifferences}
package onjava;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

// onjava/CollectionMethodDifferences.java
// {java onjava.CollectionMethodDifferences}

// 打印子类的特有方法以及子类的接口列表的工具类，挺有意思
public class CollectionMethodDifferences {
    // 将传入类的方法转为TreeSet集合
    static Set<String> methodSet(Class<?> type) {
        return Arrays.stream(type.getMethods())
                .map(Method::getName)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    static void interfaces(Class<?> type) {
        // 列出传入类型的所有父类接口
        System.out.print("Interfaces in" + type.getSimpleName() + ": ");
        System.out.println(Arrays.stream(type.getInterfaces())
                .map(Class::getSimpleName)
                .collect(Collectors.toList())
        );
    }

    static Set<String> object = methodSet(Object.class);

    // 优先于构造函数执行
    static {
        object.add("clone");
    }

    // 打印 子类中特有的方法，以及子类的所有接口列表
    static void difference(Class<?> superset, Class<?> subset) {
        System.out.print(superset.getSimpleName() + ", extends " + subset.getSimpleName() + ", adds: ");
        Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
        comp.removeAll(object); // 将 超类 Object 中的方法 remove
        System.out.println(comp);
        // 获取 superset 的接口列表
        interfaces(superset);
    }

    public static void main(String[] args) {
        // 打印 Collection 类的方法
        System.out.println("Collection: " + methodSet(Collection.class));

        // Collection 的接口
        interfaces(Collection.class);

        // Set 和 Collection 的差集（也就是 Set中子类特有的方法）
        difference(Set.class, Collection.class);

        difference(HashSet.class, Set.class);

        difference(LinkedHashSet.class, HashSet.class);

        // TreeSet 增加了很多方法
        difference(TreeSet.class, Set.class);

        difference(List.class, Collection.class);

        difference(ArrayList.class, List.class);

        difference(LinkedList.class, List.class);

        difference(Queue.class, Collection.class);

        difference(PriorityQueue.class, Queue.class);

        System.out.println("Map: " + methodSet(Map.class));

        difference(HashMap.class, Map.class);

        difference(LinkedHashMap.class, HashMap.class);

        difference(SortedMap.class, Map.class);

        difference(TreeMap.class, Map.class);
    }
}

