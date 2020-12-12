package streams;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/21 7:11 下午
 */

public class FileToWordsTest {
    public static void main(String[] args) throws Exception {
        FileToWords.stream("/Users/xuyanxin/Documents/xu-self-project/aibook/aibook-book/src/main/java/com/aibook/onjava/streams/Cheese.dat")
                .limit(7)
                .forEach(s -> System.out.format("%s ", s));
        System.out.println();
        FileToWords.stream("Cheese.dat")
                .skip(7)
                .limit(2)
                .forEach(s -> System.out.format("%s ", s));
    }
}
