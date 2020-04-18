package chapter7;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/17 2:00 下午
 */
// 改写 interrupt 方法将非标准的取消操作封装在 Thread 中：
public class ReaderThread extends Thread {
    private static final int BUFFER_SIZE = 512;
    private final Socket socket;
    private final InputStream in;

    public ReaderThread(Socket socket, InputStream in) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    // 非标准的取消操作
    public void interrupt() {
        try {
            socket.close();
        } catch (IOException e) {
            // 忽略
        } finally {
            // 中断线程
            super.interrupt();
        }
    }

    @Override
    public void run() {
        byte[] buf = new byte[BUFFER_SIZE];
        while (true) {
            try {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else if (count > 0) {
                    processBuffer(buf, count);
                }
            } catch (IOException e) {
                // 允许线程退出
            }
        }
    }

    // 处理Buffer的逻辑
    public void processBuffer(byte[] buf, int count) {
    }
}
