// onjava/BasicSupplier.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Supplier from a class with a no-arg constructor
package onjava;

import java.util.function.Supplier;

// onjava/BasicSupplier.java
// Supplier from a class with a no-arg constructor
public class BasicSupplier<T> implements Supplier<T> {

    // 所包含的类对象
    private Class<T> type;

    public BasicSupplier(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get() {
        try { // 通过 Class 类型创建对应类的对象
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    // 生成一个默认的 Supplier
    public static <T> Supplier<T> create(Class<T> type) {
        return new BasicSupplier<>(type);
    }
}
