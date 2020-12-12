package functional;

import java.util.function.BiConsumer;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 1:25 上午
 */

// MethodConversion.java
class In1 {}

class In2 {}


public class MethodConversion {
    static void accept(In1 i1, In2 in2) {
        System.out.println("accept()");
    }

    static void someOtherName(In1 i1, In2 in2) {
        System.out.println("Some Other Name");
    }

    public static void main(String[] args) {
        // 去看看 BiConsumer 的源码就会发现，这是一个 有2个类型参数的泛型类
        // 接口抽象函数 accept() 入参是 2个类型参数的类 这里对应 静态方法 accept() 和 someOtherName()
        BiConsumer<In1, In2> bic;
        // 调用 accept
        bic = MethodConversion::accept;
        bic.accept(new In1(), new In2());

        // 调用 someOtherName()
        bic  = MethodConversion::someOtherName;
        bic.accept(new In1(), new In2());
    }
}
