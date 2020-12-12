package generics;

import typeinfo.PetCount3;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/29 3:24 下午
 */
// generics/GenericMethods.java
public class GenericMethods {
    public <T> void f(T t) {
        System.out.println(t.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericMethods gc = new GenericMethods();
        gc.<String>f("");
        gc.f(1);
        gc.f(1.0);
        gc.f('c');
        gc.f(gc);
    }
}
