package exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/27 3:36 下午
 */
// TryWithResources.java
public class TryWithResources {
    public static void main(String[] args) {
        try (
                FileInputStream in = new FileInputStream(new File("InputFile2.java"))
        ) {
            int contents = in.read();
            // 处理 contents
            System.out.println(contents);
        } catch (IOException e) {
            // 处理异常
            System.out.println(e);
        }
    }
}
