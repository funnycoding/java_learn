package generics;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/11 2:26 上午
 */

class Bob {}

public class Diamond<T> {
    public static void main(String[] args) {
        GenericHolder<Bob> h3 = new GenericHolder<>();
        h3.set(new Bob());
    }
}