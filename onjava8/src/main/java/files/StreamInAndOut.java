package files;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/24 6:08 下午
 */
// StreamInAndOut.java
public class StreamInAndOut {
    public static void main(String[] args) {
        // 这里使用了 try-with-resource
        try (
                Stream<String> input = Files.lines(Paths.get("StreamInAndOut.java"));
                PrintWriter output = new PrintWriter("StreamInAndOut.txt");
        ) {
            input.map(String::toUpperCase)
                    .forEachOrdered(output::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
