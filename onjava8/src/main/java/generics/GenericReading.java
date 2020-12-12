package generics;

import java.util.Arrays;
import java.util.List;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/15 12:12 下午
 */

// generics/GenericReading.java
public class GenericReading {
    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruits = Arrays.asList(new Fruit());

    // 泛型方法，返回 List 的第一个元素
    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    // A static method adapts to each call 适配器方法
    static void f1() {
        Apple apple = readExact(apples);
        Fruit fruit = readExact(fruits);
        fruit = readExact(apples);
    }

    // 这里是一个静态内部类，带有一个泛型参数，但是作用好像跟上面的泛型方法应该是一样的
    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    static void f2() {
        Reader<Fruit> fruitReader = new Reader<>();
        Fruit f = fruitReader.readExact(fruits);
        //Fruit fruit = fruitReader.readExact(apples); // Error Require List<Fruit> Provide List<Apple>
    }

    // 协变类型
    static class ConvariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3() {
        ConvariantReader<Fruit> fruitReader = new ConvariantReader<>();
        Fruit f = fruitReader.readCovariant(fruits);
        Fruit a = fruitReader.readCovariant(apples);
    }


    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }
}
