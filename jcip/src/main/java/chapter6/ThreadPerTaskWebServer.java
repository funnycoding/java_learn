package chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/13 6:30 下午
 */

// 为每个请求都创建一个线程来对其进行处理
public class ThreadPerTaskWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true) {
            final Socket connection = serverSocket.accept();
            Runnable task = () -> handleRequest(connection);
        }
    }

    private static void handleRequest(Socket connection) {
        // 在这里做具体的业务逻辑处理
    }
}
