package exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/27 1:27 下午
 */
// InputFile.java
public class InputFile {
    private BufferedReader in;

    public InputFile(String fileName) throws Exception {
        // 最终都没有处理异常，而是选择抛出
        try {
            in = new BufferedReader(new FileReader(fileName));
            // 其他可能引发异常的代码
        } catch (FileNotFoundException e) {
            System.out.println("打开文件失败: " + fileName);
            // 没有打开指定文件，所以没有关闭它
            throw e;
        } catch (Exception e) {
            // 所以其他异常必须在这里被关闭
            try {
                in.close();
            } catch (IOException e2) {
                System.out.println("BufferReader 输入流关闭失败");
            }
            throw e; // 重新抛出打开失败异常
        }finally {
            // 不要在这里关闭
        }
    }

    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine() field");
        }
        return s;
    }

    public void dispose() {
        try {
            in.close();
            System.out.println("dispose() successful");
        } catch (IOException e) {
            throw new RuntimeException("in.close failed");
        }
    }
}
