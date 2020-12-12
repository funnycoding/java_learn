package generics;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/3/15 9:13 下午
 */
// generics/GenericCast.java
class FixedSizeStack<T> {
    private final int size;
    private Object[] storage;
    private int index = 0;

    FixedSizeStack(int size) {
        this.size = size;
        storage = new Object[size];
    }

    public void push(T item) {
        if (index < size) {
            storage[index++] = item;
        }
    }

    // 这是一个栈结构
    @SuppressWarnings("unchecked")
    public T pop() {
        System.out.println("index: " + index);
        return index == 0 ? null : (T) storage[--index];
    }

    @SuppressWarnings("unchecked")
    Stream<T> stream() {
        return (Stream<T>) Arrays.stream(storage);
    }
}


public class GenericCast<T> {
    static String[] letters = "ABCDEFGHIJKLMNOPQRS".split("");

    public static void main(String[] args) {
        FixedSizeStack<String> strings = new FixedSizeStack<>(letters.length);
        Arrays.stream("ABCDEFGHIJKLMNOPQRS".split(""))
                .forEach(strings::push);
        System.out.println(strings.pop());
        strings.stream()
                .map(s -> s+" ")
                .forEach(System.out::print);
    }
}
