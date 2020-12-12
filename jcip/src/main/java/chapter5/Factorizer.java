package chapter5;

import java.math.BigInteger;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/7 6:58 下午
 */

// 使用 高效缓存的 因式分解 Servlet
public class Factorizer extends GenericServlet implements Servlet {

    // 这里使用了方法引用
    private final Computable<BigInteger, BigInteger[]> c = this::factor;

    private final Computable<BigInteger, BigInteger[]> cache = new Memoizer<>(c);

    @Override
    public void service(ServletRequest req, ServletResponse resp) {
        try {
            BigInteger i = extractFromRequest(req);
            // 从缓存中获取值，如果没有则计算值
            encodeIntoResponse(resp, cache.compute(i));
        } catch (InterruptedException e) {
            encodeError(resp, "factorization interrupted");
        }
    }


    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    void encodeError(ServletResponse resp, String errorString) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }
}
