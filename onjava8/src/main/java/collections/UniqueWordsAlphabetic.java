package collections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/16 4:09 下午
 */

public class UniqueWordsAlphabetic {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(
                Paths.get("/Users/xuyanxin/Documents/xu-self-project/aibook/aibook-book/src/main/java/com/aibook/onjava/twelve/SetOperations.java"));

        // 這裡創建Set的时候传入了比较器，所以添加进去的元素按字幕顺序进行排序
        Set<String> words =
                new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        for (String line : lines) {
            for (String word : line.split("\\W+")) {
                if (word.trim().length() > 0) {
                    words.add(word);
                }
            }
        }
        System.out.println(words);
    }
}
