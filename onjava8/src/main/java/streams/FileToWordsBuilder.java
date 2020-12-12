package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/21 2:37 下午
 */

// FileToWordsBuilder.java
public class FileToWordsBuilder {
    Stream.Builder<String> builder = Stream.builder();

    // 当 Stream 真正被构件时该标志位被设置为 true.
    boolean isStreamBuild = false;

    public FileToWordsBuilder(String filePath) throws IOException {
        Files.lines(Paths.get(filePath))
                .skip(1) // 跳过开头行
                .forEach(line -> {
                    for (String w : line.split("[ .?,]+")) { // 这里的正则是以空格开头的
                        builder.add(w);
                    }
                });
    }

    // 手动向 Builder中添加单词的方法
    public void addToBuilder(String words) {
        builder.add(words);
    }



    // 构造一个Stream
    Stream<String> stream() {
        isStreamBuild = true;
        return builder.build();
    }

    public static void main(String[] args) throws IOException {
        FileToWordsBuilder fileToWordsBuilder = new FileToWordsBuilder(
                "/Users/xuyanxin/Documents/xu-self-project/aibook/aibook-book/src/main/java/com/aibook/onjava/streams/Cheese.dat");
        fileToWordsBuilder.addToBuilder("手动添加一哈");
        Stream<String> stream = fileToWordsBuilder
                .stream();
        //fileToWordsBuilder.addToBuilder("Builder被构建为 Stream之后再添加点元素进去"); // 当Builder 已经被构建时再调用 add()会导致异常
        stream
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
