package functional;

import java.util.function.IntSupplier;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 3:33 下午
 */
// Closure1.java
// 使用Lambda 表达式对 改变类字段
public class Closure1 {
    int i;

    // 这里使用到了类变量 i
    IntSupplier makeFun(int x) {
        // 这里使用了 传入方法的参数 x 以及方法外的类字段 i
        return () -> x + i++;
    }

    public static void main(String[] args) {
        Closure1 closure1 = new Closure1();
        System.out.println("Before makeFun make i++, i :" + closure1.i);
        System.out.println("makeFun Return value: " + closure1.makeFun(10).getAsInt());
        System.out.println("After makeFun make i++, i :" + closure1.i);
    }
}
