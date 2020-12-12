package generics;

import java.util.List;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/15 11:48 上午
 */
// generics/SuperTypeWildcards.java
public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        // apples.add(new Fruit()); // Error
    }

    // 与之前的 ? extends 他们的父类 Fruit 做对比
    static void writeTo2(List<? extends Fruit> fruits) {
        //fruits.add(new Apple()); // 编译器异常
        //fruits.add(new Jonathan()); // 编译器异常
    }
}
