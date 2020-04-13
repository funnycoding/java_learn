package chapter6;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/13 5:55 下午
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 一个单线程串行执行的 Web Server
 */
public class SingleThreadWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            // 接收客户端的请求
            Socket connection = socket.accept();
            // 以串行的形式处理请求
            handleRequest(connection);
        }
    }

    // 具体对请求做处理的逻辑，在这里我们不需要关心
    private static void handleRequest(Socket connection) {

    }
}
