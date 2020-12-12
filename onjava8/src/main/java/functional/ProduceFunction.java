package functional;

import java.util.function.Function;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 2:53 下午
 */

// ProduceFunction.java
// 继承了 Function 接口，返回值和入参类型相同
interface MyFunction extends Function<String, String> {
} // [1]

public class ProduceFunction {
    // 相当于返回了一个匿名类对象，该实例重写了 apply() 方法，行为是将传入的字符串转为小写
    static MyFunction produce() {
        return s -> s.toLowerCase(); // [2]
    }

    public static void main(String[] args) {
        MyFunction f = produce();
        System.out.println(f.apply("YELLING"));
    }
}
