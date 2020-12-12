package streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/21 1:42 下午
 */
// Generator.java
public class Generator implements Supplier<String> {
    Random rand = new Random(47);
    char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    int i = 0;

    // 这个 get 是在什么时候被调用的呢？
    @Override
    public String get() {
        System.out.println("get 被调用了" + i);
        i++;
        return "" + letters[rand.nextInt(letters.length)];
    }

    public static void main(String[] args) {
        String word = Stream.generate(new Generator())
                .limit(30)
                .collect(Collectors.joining());
        System.out.println(word);
    }
}
