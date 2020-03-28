package chapter2;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/3/26 7:06 下午
 */

// 缓存上次计算结果的 Servlet ，不具有足够的原子性 ，存在竞态条件
// UnsafeCachingFactorizer.java
public class UnsafeCachingFactorizer extends GenericServlet implements Servlet {
    // 缓存上次要分解的值
    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<>();
    // 缓存上次分解的结果
    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<>();


    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) {
        BigInteger i = extractFromRequest(servletRequest);
        if (i.equals(lastNumber.get())) {
            encodeIntoResponse(servletResponse, lastFactors.get());
        } else {
            BigInteger[] factors = factor(i);
            // 这里更新两个原子变量的过程中 并不是原子操作，可能产生竞态条件 线程 A 获取2个值的过程中 线程B 可能修改了它们
            // 虽然单个原子引用的 set 方法是 原子操作，但是2个 原子引用 同时赋值 就不是一个原子操作了，这里强调整体性
            lastNumber.set(i);
            lastFactors.set(factors);
            encodeIntoResponse(servletResponse, factors);
        }
    }

    // 返回结果
    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    // 从请求中提取入参
    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    // 因式分解的具体业务方法
    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }
}
