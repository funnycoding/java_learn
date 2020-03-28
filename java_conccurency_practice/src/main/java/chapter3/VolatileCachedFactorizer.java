package chapter3;

import java.math.BigInteger;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import net.jcip.annotations.ThreadSafe;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/3/26 7:45 下午
 */

// Caching the last result using a volatile reference to an immutable holder object
// 使用 volatile + 不可变对象容器封装缓存数据
// VolatileCachedFactorizer.java

@ThreadSafe
public class VolatileCachedFactorizer extends GenericServlet implements Servlet {
    // 使用 volatile 保证变量的可见性，当其被更新时其他使用线程能立即获取最新值
    private volatile OneValueCache cache = new OneValueCache(null, null);

    @Override
    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = cache.getFactors(i);
        if (factors == null) {
            factors = factor(i);
            // 更新缓存 volatile 保证线程的可见性
            cache = new OneValueCache(i, factors);
        }
        encodeIntoResponse(resp, factors);
    }

    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }
}
