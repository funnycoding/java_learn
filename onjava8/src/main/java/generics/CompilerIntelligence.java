package generics;

import java.util.Arrays;
import java.util.List;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/14 11:15 下午
 */
// generics/CompilerIntelligence.java
public class CompilerIntelligence {
    public static void main(String[] args) {
        // 相当于把一个 List<Apple> 赋值给 List<? extends Fruit>
        List<? extends Fruit> flist = Arrays.asList(new Apple());

        Apple apple = (Apple) flist.get(0); // 不会产生警告

        //flist.add(new Apple()); // Compiler Error

        System.out.println(flist.contains(new Apple())); // Argument is 'Object'
        System.out.println(flist.indexOf(new Apple())); // Argument is 'Object'

    }
}
