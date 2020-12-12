package generics;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/13 11:56 上午
 */

public class Manipulator3 {
    private Hasf obj;

    Manipulator3(Hasf x) {
        obj = x;
    }

    public void manipulate() {
        obj.f();
    }
}
