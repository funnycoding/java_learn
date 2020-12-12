package exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/27 3:22 下午
 */
// InputFile2.java
public class InputFile2 {
    private String fname;

    public InputFile2(String fname) {
        this.fname = fname;
    }
    public Stream<String> getLines() throws IOException {
        return Files.lines(Paths.get(fname));
    }

    public static void main(String[] args) throws IOException {
        new InputFile2("InputFile22.java").getLines()
                .skip(15)
                .limit(1)
                .forEach(System.out::println);
    }
}
