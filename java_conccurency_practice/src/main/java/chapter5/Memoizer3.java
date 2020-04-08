package chapter5;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/7 6:27 下午
 */
// 使用 FutureTask 改进 可能存在多个线程计算同一个值的情况
public class Memoizer3<A, V> implements Computable<A, V> {
    // 这里 的Value 从 泛型元素 V 变为了由 Future 类，Future 的泛型元素是V
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer3(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);

        if (f == null) {
            Callable<V> eval = () -> c.compute(arg);

            FutureTask<V> ft = new FutureTask<>(eval);
            f = ft;
            cache.put(arg, ft);
            ft.run(); //这里调用 c.compute 方法
        }
        // 获取 FutureTask 的计算的值，如果正在计算中，则阻塞，直到其值返回
        try {
            return f.get();
        } catch (ExecutionException e) {
            throw LaunderThrowable.launderThrowable(e.getCause());
        }
    }
}
