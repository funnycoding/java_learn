package streams;

import java.util.Comparator;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/21 4:51 下午
 */

// SortedComparator.java
public class SortedComparator {
    public static void main(String[] args) throws Exception {
        FileToWords
                .stream("/Users/xuyanxin/Documents/xu-self-project/aibook/aibook-book/src/main/java/com/aibook/onjava/streams/Cheese.dat")
                .skip(10)
                .limit(10)
                .sorted(Comparator.reverseOrder())
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
