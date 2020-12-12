package streams;

import java.util.stream.LongStream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/21 5:04 下午
 */

// Prime.java
public class Prime {
    public static boolean isPrime(long n) {
        return LongStream.rangeClosed(2, (long) Math.sqrt(n))
                .noneMatch(i -> n % i == 0);
    }

    public LongStream numbers() {
        return LongStream.iterate(2, i -> i + 1)
                .filter(Prime::isPrime);
    }

    public static void main(String[] args) {
        new Prime()
                .numbers()
                .limit(10)
                .forEach(n -> System.out.format("%d ", n));

        System.out.println();

        new Prime().numbers()
                .skip(90)
                .limit(10)
                .forEach(n -> System.out.format("%d ", n));
    }
}
