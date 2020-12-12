package generics;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/13 11:41 上午
 */

// Manipulator2.java
public class Manipulator2 <T extends Hasf> {
    private T obj;

    Manipulator2(T x) {
        obj = x;
    }
    // 因为类型参数一定继承 Hasf 所以一定具有 f()
    public void manipulate() {
        obj.f();
    }
}
