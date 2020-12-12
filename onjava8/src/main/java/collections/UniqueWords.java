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
 * @date 2020/2/16 4:01 下午
 */

public class UniqueWords {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(
                Paths.get("/Users/xuyanxin/Documents/xu-self-project/aibook/aibook-book/src/main/java/com/aibook/onjava/twelve/SetOperations.java"));
        Set<String> words = new TreeSet<>();
        for(String line : lines)
            for(String word : line.split("\\W+"))
                if(word.trim().length() > 0)
                    words.add(word);
        System.out.println(words);
    }
}
