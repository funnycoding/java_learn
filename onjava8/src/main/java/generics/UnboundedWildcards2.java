package generics;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/3/15 2:57 下午
 */
// generics/UnboundedWildcards2.java
public class UnboundedWildcards2 {
    // 先来一个RawType Map
    static Map map1;
    // 再来一个不限制泛型类型的 Map
    static Map<?, ?> map2;

    // 再来一个 一个Key为String Value 随意的 Map
    static Map<String, ?> map3;

    // 下来分别写对map进行赋值的方法

    static void assign1(Map map) {
        map1 = map;
    }

    static void assign2(Map<?, ?> map) {
        map2 = map;
    }

    static void assign3(Map<String, ?> map) {
        map3 = map;
    }

    public static void main(String[] args) {
        assign1(new HashMap()); //ok
        assign2(new HashMap()); //ok
        assign3(new HashMap()); // 编译警告 跟上个例子一样，无法确认 HashMap 是 HashMap<String,?> 类型的

        assign1(new HashMap<>());
        assign2(new HashMap<>());
        assign3(new HashMap<>());
    }

}
