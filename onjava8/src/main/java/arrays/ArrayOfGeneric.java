package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/7 6:38 下午
 */
// ArrayOfGeneric.java
public class ArrayOfGeneric {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];

        ls = (List<String>[]) la;//  忽略未检查异常的注解起作用了，否则编译器会在这里有一个警告

        ls[0] = new ArrayList<>();
        ls[0].add("aaa");
        System.out.println(Arrays.deepToString(ls));
        //这里编译器会抛出异常，ArrayList 类型参数为 Integer 的对象无法转换为 ArrayList 类型为 String 的对象
        //ls[1] = new ArrayList<Integer>();

        // 将ls 的引用指向 Object 类型的数组是可以的
        // 编译和运行都不会出错
        Object[] objects = ls;

        objects[1] = new ArrayList<>();
        System.out.println(Arrays.deepToString(objects));

        // 也可以直接创建泛型数组，只是需要一个忽略警告的注解

        List<BerylliumSphere>[] sphers = new List[10];

        Arrays.setAll(sphers, n -> new ArrayList<>());
        System.out.println(Arrays.deepToString(sphers));
    }
}
