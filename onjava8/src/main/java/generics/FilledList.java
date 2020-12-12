package generics;

import arrays.Suppliers;
import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/13 2:58 下午
 */

// FilledList.java
public class FilledList<T> extends ArrayList<T> {
    FilledList(Supplier<T> gen, int size) {
        Suppliers.fill(this, gen, size);
    }

    public FilledList(T t, int size) {
        for (int i = 0; i < size; i++) {
            // 因为本垒继承了 ArrayList
            this.add(t);
        }
    }

    public static void main(String[] args) {
        // 第一种方式是直接添加到 FilledList 中 这里调用的 ArrayList 中的 add() 方法
        FilledList<String> strList = new FilledList<>("Hello", 4);
        System.out.println(strList);
        // Supplier version: 使用 Supplier 生成 4个元素为 47的 Int 列表
        FilledList<Integer> intList = new FilledList<>(() -> 47, 4);
        System.out.println(intList);
    }
}
