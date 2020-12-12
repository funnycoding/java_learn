package functional;

import java.util.function.IntSupplier;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 3:51 下午
 */
// functional/Closure2.java
public class Closure2 {
    IntSupplier makeFun(int x) {
        int i = 0;
        return () -> x + i;
    }

    public static void main(String[] args) {
        Closure2 closure2 = new Closure2();
        IntSupplier intSupplier = closure2.makeFun(2);
        System.out.println(intSupplier.getAsInt());
    }
}
