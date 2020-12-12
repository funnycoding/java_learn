package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/24 6:01 下午
 */
// files/ReadLineStream.java
public class ReadLineStream {
    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("PathInfo.java"))
                .skip(13)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
