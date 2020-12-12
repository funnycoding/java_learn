package generics.coffee;

import java.util.StringJoiner;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/11 4:07 下午
 */
// Coffee.java
// 演示类的爸爸
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
