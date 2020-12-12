package streams;

import java.io.IOException;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/22 10:28 下午
 */

public class Informational {
    public static void main(String[] args) throws IOException {
        System.out.println(
                FileToWords.stream("/Users/xuyanxin/Documents/xu-self-project/aibook/aibook-book/src/main/java/com/aibook/onjava/streams/Cheese.dat").count());
        System.out.println(
                FileToWords.stream("/Users/xuyanxin/Documents/xu-self-project/aibook/aibook-book/src/main/java/com/aibook/onjava/streams/Cheese.dat")
                        .min(String.CASE_INSENSITIVE_ORDER)
                        .orElse("NONE"));
        System.out.println(
                FileToWords.stream("/Users/xuyanxin/Documents/xu-self-project/aibook/aibook-book/src/main/java/com/aibook/onjava/streams/Cheese.dat")
                        .max(String.CASE_INSENSITIVE_ORDER)
                        .orElse("NONE"));
    }
}
