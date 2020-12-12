package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/20 10:03 下午
 */
// RandomWords.java
public class RandomWords implements Supplier<String> {

    List<String> words = new ArrayList<>();
    Random rand = new Random(47);

    RandomWords(String fileName) throws IOException {
        // 读取传入文件路径的所有内容
        // 这里Paths 路径获取文件中的文件必须在 Parents 文件夹下面，否则只能根据绝对路径查找对应的文件
        List<String> lines = Files.readAllLines(Paths.get(fileName));

        // 略过第一行
        for (String line : lines.subList(1, lines.size())) {
            for (String word : line.split("[ .?,]+")) {
                words.add(word.toLowerCase());
            }
        }
    }


    @Override
    public String get() {
        return words.get(rand.nextInt(words.size()));
    }

    @Override
    public String toString() {
        return words.stream().collect(Collectors.joining("  "));
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Stream.generate(new RandomWords("/Users/xuyanxin/Documents/xu-self-project/aibook/aibook-book/src/main/java/com/aibook/onjava/streams/Cheese.dat"))
                .limit(10)
                .collect(Collectors.joining(" ")));
    }
}
