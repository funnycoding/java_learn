package generics;

import java.lang.reflect.Array;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/14 10:14 上午
 */
// generics/GenericArrayWithTypeToken.java
public class GenericArrayWithTypeToken<T> {
    private T[] array;


    // 生成对应类型的指定长度的数组并进行类型强转
    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int sz) {
        array = (T[]) Array.newInstance(type, sz);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    // 在这里也不需要对元素进行强转，因为之前的数组已经被强转为对应类型
    public T get(int index) {
        return array[index];
    }

    // Expose the underlying representation:
    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<>(
                Integer.class, 10);
        // 此时不会在生成类型转换异常
        Integer[] rep = gai.rep();
    }
}
