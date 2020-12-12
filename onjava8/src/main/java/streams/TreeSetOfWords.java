package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/22 7:18 下午
 */

public class TreeSetOfWords {
    public static void main(String[] args) throws IOException {
        Set<String> words2 =
                Files.lines(Paths.get("/Users/xuyanxin/Documents/xu-self-project/aibook/aibook-book/src/main/java/com/aibook/onjava/streams/TreeSetOfWords.java"))
                        .flatMap(s -> Arrays.stream(s.split("\\W+")))
                        .filter(s -> !s.matches("\\d+")) // 非数字
                        .map(String::trim)
                        .filter(s -> s.length() > 2)
                        .limit(100)
                        .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(words2);
    }
}
