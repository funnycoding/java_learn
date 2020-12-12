package files;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/24 4:20 下午
 */
// Directories.java
public class Directories {
    static Path test = Paths.get("test");
    static String sep = FileSystems.getDefault().getSeparator();

    static List<String> parts = Arrays.asList("foo", "bar", "baz", "bag");

    static Path makeVariant() {
        Collections.rotate(parts, 1);
        return Paths.get("test", String.join(sep, parts));
    }

    static void refreshTestDir() throws IOException {
        if (Files.exists(test)) {
            System.out.println("test已经存在，开始删除该目录");
            RmDir.rmdir(test);
        }
        // 直接一个 else 不就行了么。。。 其实不行，因为如果 else 的话就二选一了，这里是需要2个都执行
        if (!Files.exists(test)) {
            System.out.println("test不存在，开始创建目录...");
            Files.createDirectory(test);
        }
    }

    public static void main(String[] args) throws IOException {
        refreshTestDir();
        Files.createFile(test.resolve("Hello.txt"));

        Path variant = makeVariant();
        try {
            Path directory = Files.createDirectory(variant);
        } catch (Exception e) {
            System.out.println("创建 Directory 并没有工作");
        }

        populateTestDir();

        Path tempDir = Files.createTempDirectory(test, "DIR_");
        Files.createTempFile(tempDir, "pre", ".non");

        Files.newDirectoryStream(test).forEach(System.out::println);
        System.out.println("*****************");
        // 遍历了
        Files.walk(test).forEach(System.out::println);


    }

    static void populateTestDir() throws IOException {
        for (int i = 0; i < parts.size(); i++) {
            Path variant = makeVariant();
            if (!Files.exists(variant)) {
                Files.createDirectories(variant);
                Files.copy(Paths.get("Directories.java"), variant.resolve("File.txt"));
                Files.createTempFile(variant, null, null);
            }
        }
    }
}
