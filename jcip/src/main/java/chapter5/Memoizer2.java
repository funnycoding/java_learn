package chapter5;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/7 6:06 下午
 */
// 使用同步容器 ConcurrentHashMap 构建缓存
public class Memoizer2<A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    // 当使用同步容器 ConcurrentHashMap 时 ，不需要在方法上加锁
    @Override
    public V compute(A arg) throws InterruptedException {
        V resul = cache.get(arg);
        if (resul == null) {
            resul = c.compute(arg);
            cache.put(arg, resul);
        }
        return resul;
    }
}
