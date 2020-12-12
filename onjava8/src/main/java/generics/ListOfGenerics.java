package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/13 8:37 下午
 */
// generics/ListOfGenerics.java
// 泛型类使用 ArrayList 存储类型对象实例
public class ListOfGenerics<T> {
    private List<T> array = new ArrayList<>();

    public void add(T t) {
        array.add(t);
    }

    public T get(int index) {
        return array.get(index);
    }
}
