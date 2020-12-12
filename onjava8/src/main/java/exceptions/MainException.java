package exceptions;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/27 6:47 下午
 */

public class MainException {
    // 传递异常到控制台
    public static void main(String[] args) throws Exception {
        final List<String> strings = Files.readAllLines(Paths.get("MainException.java"));
    }
}
