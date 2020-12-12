// onjava/Sets.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package onjava;

import java.util.HashSet;
import java.util.Set;

//Sets.java
public class Sets {
    // 入参是2个Set，返回这2个 Set 的并集
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    // 返回 SetA 与 SetB 的交集
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    // 返回两个集合之间的差集
    public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
        Set<T> result = new HashSet<>(superset);
        result.removeAll(subset);
        return result;
    }

    // Reflexive--everything not in the intersection:
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        // a 与 b 的并集 与 a与b 的交集 做差集
        return difference(union(a, b), intersection(a, b));
    }
}
