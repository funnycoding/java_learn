package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/24 5:21 下午
 */

public class ListOfLines {
    public static void main(String[] args) throws IOException {
        Files.readAllLines(Paths.get("aibook-book/src/main/java/com/aibook/onjava/streams/Cheese.dat"))
                .stream()
                .filter(line -> !line.startsWith("//"))
                .map(line -> line.substring(0, line.length() / 2))
                .forEach(System.out::println);
    }
}
