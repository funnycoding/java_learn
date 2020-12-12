package chapter2;

import java.math.BigInteger;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import net.jcip.annotations.GuardedBy;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/3/21 3:42 下午
 */
// 使用更细粒度的内置锁既保证线程安全，又保证了代码的性能与活跃性。
// CachedFactorizer.java
public class CachedFactorizer extends GenericServlet implements Servlet {
    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;

    @GuardedBy("this")
    private long hits; // 访问计数器

    @GuardedBy("this")
    private long cacheHits; // 缓冲命中计数器

    // 获取访问计数被锁保护
    public synchronized long getHits() {
        return hits;
    }

    // 缓存命中率
    public synchronized double getCacheHitRation() {
        return (double) cacheHits / hits;
    }

    // 涉及对对象实例状态的操作都需要被内置锁保护使 操作实力域的代码块成为原子操作
    @Override
    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = null;
        synchronized (this) { // 当前对象作为锁，内置锁。
            ++hits;
            if (i.equals(lastNumber)) {
                factors = lastFactors.clone();
            }
        }

        // 下面这部分不需要被锁保护
        if (factors == null) {
            factors = factor(i);
            synchronized (this) {
                lastNumber = i;
                lastFactors = factors.clone();
            }
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
