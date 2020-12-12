package functional;

import java.util.function.Function;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 3:07 下午
 */

// TransformFunction.java
class I {
}

class O {
    // 构造 O 对象时输出该语句
    public O() {
        System.out.println("O的构造函数被调用了");
    }

    @Override
    public String toString() {
        return "OOO";
    }
}


public class TransformFunction {
    // 这个方法的入参也是一个 Function 可以看做是一个函数 一种行为
    // 入参是一种行为 返回值也是一种行为，消费行为，生成行为
    // 这里我觉得如果刚开始看不太明白的话，直接通过IDE的功能将 lambda 展开为 匿名内部类 就会看得非常清楚了
    // 这里实现了一个 Function 的匿名内部类，类中的 apply 方法 打印入参 然后不做处理直接返回

    /**
     * 将 Lambda 展开为匿名内部类形式
     * static Function<I, O> transform(Function<I, O> in) {
     * return in.andThen(new Function<O, O>() {
     *
     * @Override public O apply(O o) {
     * System.out.println(o);
     * return o;
     * }
     * });
     * }
     */

    // Lambda
    // 然后在看一下 andThen 函数的定义
    static Function<I, O> transform(Function<I, O> in) {
        System.out.println("transform 被调用了");
        return in.andThen(o -> {
            System.out.println("transform 被调用才进来的");
            System.out.println("当前对象：" + o + "apply()");
            return o;
        });
    }


    public static void main(String[] args) {
        System.out.println("第一个方法引用:myApply");
        // 方法引用赋值
        Function<I, O> ioFunction = TransformFunction::myApply;

        System.out.println("开始调用 transform(), 入参是一个 Lambda 表达式， 该表达式的入参是 i，输出i，返回 O");
        Function<I, O> f2 = transform(i -> {
            // 先打印入参 i
            System.out.println(i);
            // 构造类 O 实例
            return new O();
        });
        System.out.println("----------- f2. apply(new I())----------- ");
        O apply = f2.apply(new I()); // 调用方法引用生成对象O
        System.out.println("transform 调用结束");

        System.out.println("开始调用 iOFunction 的 apply()"); // 这里实际调用的是我下面定义的 myApply()函数
        System.out.println(ioFunction.apply(new I())); // 这里打印出来的 OOO 是 ioFunction.apply(new I()) 这里生成的对象 O
        System.out.println("-------------");
    }

    // 入参是 I返回值是 O 符合 Function 接口
    private static O myApply(I i) {
        System.out.println("这里是打印i的上一行");
        System.out.println("打印I: " + i);
        System.out.println("这里是return O 的上一行");
        // 为什么这个返回这个对象 或者说调用 O 的构造函数，toString 方法被调用了
        System.out.println("开始构造 O 对象");
        O o = new O();
        System.out.println("打印O对象 " + o);
        return o;
    }
}
