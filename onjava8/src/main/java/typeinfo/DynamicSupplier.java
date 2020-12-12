package typeinfo;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/28 8:12 下午
 */
// DynamicSupplier.java
class CountedInteger {
    private static long counter;
    private final long id = counter++;

    public CountedInteger() {
    }

    @Override
    public String toString() {
        return Long.toString(id);
    }
}

public class DynamicSupplier<T> implements Supplier<T> {

    private Class<T> type;

    public DynamicSupplier(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get() {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // 这里 Class的类型参数是 CountedInteger
        Stream.generate(new DynamicSupplier<>(CountedInteger.class))
                .skip(10)  // 跳过前10个对象 0 -9
                .limit(5)
                .forEach(System.out::println);
    }
}
