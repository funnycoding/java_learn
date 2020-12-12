package streams;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/22 7:46 下午
 */

public class SpecialCollector {
    public static void main(String[] args) throws IOException {
        ArrayList<String> words = FileToWords.stream("/Users/xuyanxin/Documents/xu-self-project/aibook/aibook-book/src/main/java/com/aibook/onjava/streams/Cheese.dat")
                .collect(
                        ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll
                );

        words.stream()
                .filter( s -> s.equals("cheese"))
                .forEach(System.out::println);
    }
}
