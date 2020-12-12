package streams;

import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/21 5:49 下午
 */
// FunctionMap2.java
class Numberd {
    final int n;

    public Numberd(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Numberd(" + n + ")";
    }
}

public class FunctionMap2 {
    public static void main(String[] args) {
        // 这里将 Stream<Integer> 流转为了 Stream<Numberd>流
        Stream.of(1,5,7,9,11,13)
                .map(Numberd::new)
                .forEach(System.out::println);
    }
}
