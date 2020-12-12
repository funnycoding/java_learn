package functional;

import java.util.StringJoiner;
import java.util.function.Function;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 2:59 下午
 */

// ConsumeFunction.java
class One {
}

class Two {
    static int i = 0;
    final int counter = i++;
    @Override
    public String toString() {
        return new StringJoiner(", ", Two.class.getSimpleName() + "[", "]")
                .add("counter=" + counter)
                .toString();
    }
}

// 我自己又加了个根据方法引用生成 Two 的
class Three {
    static Two test(One o) {
        return new Two();
    }
}

public class ConsumeFunction {
    // 入参是一个两个参数的Function，根据参数位置可以看到入参是One，返回值是 Two，与这个方法的返回值一致。
    static Two consume(Function<One, Two> oneTwo) {
        System.out.println("入参是 Function，根据 Function.apply 返回 Two对象的方法被调用了");
        return oneTwo.apply(new One());
    }

    public static void main(String[] args) {
        // 实现与 consume 相同效果的 Lambda 表达式
        Function<One, Two> f = one -> new Two();
        //  f.apply(new One) 直接可以生成一个 Two 的实例
        Two apply = f.apply(new One());
        System.out.println("使用Lambda表达式生成的对象：" + apply);

        Two consume = consume(f);
        System.out.println("使用 Consume 生成的对象：" + consume);

        Two two = consume(one -> new Two());

        System.out.println("将Lambda表达式传入 consume 生成的对象: " + two);

        // 把 Three类的test方法赋值给 Function，传入consume，也可以生成 Two 对象
        Two three = consume(Three::test);
        System.out.println("consume() + 方法引用赋值生成的 Two对象: " + three);

    }
}
