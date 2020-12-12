package generics;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/11 7:36 下午
 */
// generics/Fibonacci.java
// Generate a Fibonacci sequence
public class Fibonacci implements Supplier<Integer> {
    private int count = 0;


    @Override
    public Integer get() {
        return fib(count++);
    }

    // 生成斐波那契数列的算法
    private int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        Stream.generate(new Fibonacci())
                .limit(18)
                .map(n -> n + " ")
                .forEach(System.out::print);
    }
}
