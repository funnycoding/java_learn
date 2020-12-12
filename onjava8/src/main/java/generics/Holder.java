package generics;

import java.util.Objects;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/14 11:35 下午
 */
// generics/Holder.java
// 这里我修改了一些变量名，与书中例子的不同，更贴近例子
public class Holder<T> {
    private T value;

    public Holder() {
    }

    public Holder(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    // 首先 对象要属于 Holder 并且 Holder中持有的 value 与对象的 value 相同
    @Override
    public boolean equals(Object o) {
        return o instanceof Holder && Objects.equals(value, ((Holder) o).value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public static void main(String[] args) {
        Holder<Apple> appleHolder = new Holder<>(new Apple());
        Apple apple = appleHolder.get();
        appleHolder.set(apple);
        //Holder<Fruit> fruitHolder = appleHolder; // 编译异常 不能完成这样的类型转换
        Holder<? extends Fruit> fruitHolder = appleHolder; // 这样是 OK的
        Fruit fruit = fruitHolder.get();
        apple = (Apple) fruitHolder.get(); // 这里也是OK的，因为这里的 Fruit List 中实际保存的是 Apple 对象

        try {
            Orange c = (Orange) fruitHolder.get(); // 这里就会产生类转换异常了，因为无法将 Apple 转为 Orange 类
        } catch (Exception e) {
            System.out.println(e);
        }

        //fruitHolder.set(new Apple()); 不能这样调用 set() 方法
        //fruitHolder.set(new Fruit()); 不能这样调用 set() 方法
        System.out.println(fruitHolder.equals(apple)); // OK

    }
}
