package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/3/15 2:32 下午
 */

// generics/UnboundedWildcards1.java
public class UnboundedWildcards1 {
    static List list1;
    static List<?> list2; // 无界通配符
    static List<? extends Object> list3;

    // 这里的入参类型是 RawType 未使用泛型的List
    static void assign1(List list) {
        list1 = list; // ok  将RawType 赋值给 RawType
        list2 = list; // ok 将 RawType 赋值给使用 ? 无界通配符的 List
        //list3 = list; // 将 RawType 赋值给 extends 带有边界的List  编译器会产生警告 unchecked assignment
    }

    // 入参是一个无界List 区别于未使用反省的 RawType
    static void assign2(List<?> list) {
        list1 = list;
        list2 = list;
        list3 = list; // 三种赋值操作都不会产生警告信息
    }

    // 限定类型参数都是 Object 的子类（这不是等于没说。。。）
    static void assign3(List<? extends Object> list) {
        list1 = list;
        list2 = list;
        list3 = list; // 三种操作也不会产生警告信息
    }

    public static void main(String[] args) {
        assign1(new ArrayList());
        assign2(new ArrayList());
        // 这里会产生一个 未检查的赋值警告 ArrayList 无法被编译器确定为 ArrayList<? extends  Object> 也就是这俩无法划等号
        assign3(new ArrayList());

        // 这三个都是类型参数为 Object 的 List
        assign1(new ArrayList<>());
        assign2(new ArrayList<>());
        assign3(new ArrayList<>());
        // Both forms are acceptable as List<?>: 使用 ? 无界通配符的 List 对象可以指向不适用泛型的 List 对象
        List<?> wildList = new ArrayList();
        wildList = new ArrayList<>();
        assign1(wildList);
        assign2(wildList);
        assign3(wildList);
    }

}
