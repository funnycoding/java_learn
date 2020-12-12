package chapter5;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import net.jcip.annotations.GuardedBy;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/7 5:39 下午
 */

// Initial cache attempt using HashMap and synchronization
// 使用 HashMap  和 同步 初始化一个缓存类
public class Memoizer1<A, V> implements Computable<A, V> {
    // 作为缓存的HashMap
    @GuardedBy("this")
    private final Map<A, V> cache = new HashMap<>();

    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    // 这里将覆写的 compute 方法使用了内置锁 保证互斥
    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            // 让 Computable 的实现类进行计算 也就是 调用下面的 ExpensiveFunction compute 方法
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}

interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}

class ExpensiveFunction implements Computable<String, BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        // 经过了长时间的计算之后
        return new BigInteger(arg);
    }
}
