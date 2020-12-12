package exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/27 3:31 下午
 */
// MessyException.java
public class MessyException {
    public static void main(String[] args) {
        InputStream in = null;

        try {
            in = new FileInputStream(new File("MessyException.java"));
            int contents = in.read();
            // 处理 contents
        } catch (IOException e) {
            // 在这里处理异常
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // 在这里处理关闭的异常
                }
            }
        }
    }
}
