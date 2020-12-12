package streams;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/21 4:32 下午
 */

public class Peeking {
    public static void main(String[] args) throws Exception {
        FileToWords.stream("/Users/xuyanxin/Documents/xu-self-project/aibook/aibook-book/src/main/java/com/aibook/onjava/streams/Cheese.dat")
                .skip(21)
                .limit(4)
                .map(w -> w + " ")
                .peek(System.out::print)
                .map(String::toUpperCase)
                .peek(System.out::print)
                .map(String::toLowerCase)
                .forEach(System.out::print);
    }
}
