package streams;

import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/21 2:09 下午
 */
// Fibonacci.java
public class Fibonacci {
    int x = 1;
    Stream<Integer> numbers() {
        return Stream.iterate(0, i -> {
            int result = x + i;
            System.out.println("i numbers: " + i + "result : " + result);
            x = i;
            return result;
        });
    }

    public static void main(String[] args) {
        new Fibonacci().numbers()
                //.skip(20) // 跳过前20个
                .limit(10) // 然后取前10个
                .forEach(System.out::println);
    }
}
