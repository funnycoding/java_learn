package generics;

import onjava.Count.Integer;
import org.omg.CORBA.Object;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/13 9:18 下午
 */

// GenericArray.java
public class GenericArray<T> {
    private T[] array;

    public GenericArray(int sz) {
        array = (T[]) new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    // Method that exposes the underlying representation:
    // 返回当前 T 类型的数组
    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10);
        try {
            Integer[] ia = gai.rep();
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
        // This is OK: 这是正常的 但是实际上这里需要对返回的数组做 Object 的强转，而作者并没有这样写
        Object[] oa = (Object[]) gai.rep();
    }
}
