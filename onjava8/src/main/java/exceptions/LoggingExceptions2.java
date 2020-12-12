package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 3:22 下午
 */

// LoggingExceptions2
public class LoggingExceptions2 {
    private static Logger logger = Logger.getLogger("LoggingExceptions2");

    // 这里作为一个异常的打印器
    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            logException(e);
        }
    }
}
