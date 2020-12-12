package chapter14.io;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/5/17 6:10 下午
 */

public class Test {


    public static void main(String[] args) throws IOException {
        System.exit(0);
        System.out.println("66");
        File file = new File("test.txt");
        if (file.exists()) {
            System.out.println("已经存在");
            boolean delete = file.delete();
            System.out.println("删除文件结果："+delete);
            boolean newFile = file.createNewFile();
            System.out.println("重新创建文件："+newFile);
        }
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "Write Contens"; // 比如这是你要写入的内容 stringColors
        bufferedWriter.write(str);
        bufferedWriter.append("\r\n");
        bufferedWriter.flush();
        fileWriter.write("test");
        fileWriter.flush();
        fileWriter.close();
    }
}
