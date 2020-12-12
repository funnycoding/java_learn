package generics;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/13 2:49 下午
 */
// ArrayMaker.java
public class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }
    @SuppressWarnings("unchecked")
    T[] create(int size) {
        // 创建一个传入对象的 指定长度的数组
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> strMaker = new ArrayMaker<>(String.class);
        // 创建一个长度为9的字符串类型的空数组
        String[] strArray = strMaker.create(9);
        System.out.println(Arrays.toString(strArray));
    }
}
