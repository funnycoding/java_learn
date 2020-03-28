package chapter1;

import java.math.BigInteger;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import net.jcip.annotations.NotThreadSafe;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description 一个非线程安全的类，因为 ++count 不是原子操作
 * @date 2020/3/20 3:38 下午
 */

// 非线程安全， ++count  不是原子操作，分为读取，操作，写入 三个步骤
//UnsafeCountingFactorizer.java
@NotThreadSafe
public class UnsafeCountingFactorizer extends GenericServlet implements Servlet {

    // 定义了一个变量计数器
    private long count = 0;


    @Override
    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        // 不安全的操作，并发时可能会产生问题
        ++count;
        encodeIntoResponse(resp, factors);
    }

    void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }
}
