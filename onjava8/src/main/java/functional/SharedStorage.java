package functional;

import java.util.function.IntSupplier;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 3:47 下午
 */
// functional/SharedStorage.java
public class SharedStorage {
    public static void main(String[] args) {
        Closure1 c1 = new Closure1();

        // 多次调用同一个返回函数的方法
        IntSupplier f1 = c1.makeFun(0);
        IntSupplier f2 = c1.makeFun(0);
        IntSupplier f3 = c1.makeFun(0);

        // 输出对象中 i 的值
        System.out.println("x+i's value: " + f1.getAsInt() + " ," + "c1.i's value: " + c1.i);
        System.out.println("x+i's value: " +f2.getAsInt() + " ," + "c1.i's value: " + c1.i);
        System.out.println("x+i's value: " +f3.getAsInt() + " ," + "c1.i's value: " + c1.i);
    }
}
