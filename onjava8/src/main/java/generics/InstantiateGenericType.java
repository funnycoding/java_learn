package generics;

import java.util.function.Supplier;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/13 6:45 下午
 */

// 创建类的工厂
// generics/InstantiateGenericType.java
class ClassAsFactory<T> implements Supplier<T> {
    Class<T> kind;

    public ClassAsFactory(Class<T> kind) {
        this.kind = kind;
    }

    @Override
    public T get() {
        try {
            return kind.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}


class Employee {
    @Override
    public String toString() {
        return "Employ";
    }
}


public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        System.out.println(fe.get());
        ClassAsFactory<Integer> fi =
                new ClassAsFactory<>(Integer.class);
        try {
            System.out.println(fi.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
