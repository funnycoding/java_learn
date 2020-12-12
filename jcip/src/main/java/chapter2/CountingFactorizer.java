package chapter2;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/3/20 4:56 下午
 */

// CountingFactorizer.java
// 使用原子操作类 代替了不安全的基本类型 ++
public class CountingFactorizer extends GenericServlet implements Servlet {
    // 原子的Long类型
    private final AtomicLong count = new AtomicLong(0);

    // 线程安全的 get() 方法
    public long getCount() {
        return count.get();
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        count.incrementAndGet(); // 代替了 count++ ,这里的 count.incrementAndGet() 是一个原子操作。
        encodeIntoResponse(resp, factors);
    }

    void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return null;
    }

    BigInteger[] factor(BigInteger i) {
        return null;
    }
}
