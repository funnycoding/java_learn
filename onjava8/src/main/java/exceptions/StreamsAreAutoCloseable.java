package exceptions;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/27 3:44 下午
 */
// StreamsAreAutoCloseable.java
public class StreamsAreAutoCloseable {
    public static void main(String[] args) throws IOException {
        try (Stream<String> in = Files.lines(Paths.get("InputFile2.java"));
                PrintWriter outfile = new PrintWriter("Results.txt"); //[1]
        ) {
            in.skip(5)
                    .limit(1)
                    .map(String::toLowerCase)
                    .forEachOrdered(outfile::println);
        } //[2]
    }
}
