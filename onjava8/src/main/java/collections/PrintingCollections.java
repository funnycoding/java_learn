package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/15 4:25 下午
 */

public class PrintingCollections {

    static Collection fill(Collection<String> collection) {
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        collection.add("etc");
        collection.add("fbi");
        return collection;
    }

    static Map fill(Map<String, String> map) {
        map.put("rat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Spot");
        return map;
    }

    public static void main(String[] args) {
        // 输出看不同集合的不同的特性

        System.out.println("ArrayList: " + fill(new ArrayList<>()));
        System.out.println("LinkedList: " +fill(new LinkedList<>()));
        System.out.println("HashSet: " +fill(new HashSet<>()));
        System.out.println("TreeSet: " +fill(new TreeSet<>()));
        System.out.println("LinkedHashSet: " +fill(new LinkedHashSet<>()));
        System.out.println("HashMap: " +fill(new HashMap<>()));
        System.out.println("TreeMap: " +fill(new TreeMap<>()));
        System.out.println("LinkedHashMap: " +fill(new LinkedHashMap<>()));
    }
}
