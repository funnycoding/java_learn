package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 3:00 下午
 */

// LoggingException.java

class LoggingException extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException");

    // 创建这个异常对象的时候会将栈轨迹打印
    public LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString()); // 将栈信息转为String并打印
    }
}

public class LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught: " + e);
        }

        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
    }
}
