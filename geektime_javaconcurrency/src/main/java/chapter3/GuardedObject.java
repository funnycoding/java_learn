package chapter3;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/8/18 9:42 下午
 */

public class GuardedObject<T> {
    // 受保护的对象
    T obj;
    final Lock lock = new ReentrantLock();

    // 条件
    final Condition done = lock.newCondition();

    final int timeout = 2;

    // 保存所有 GuardedObject
    final static Map<Object, GuardedObject> gos = new ConcurrentHashMap<>();

    // 静态方法创建 GuardedObject
    static <K> GuardedObject create(K key) {
        GuardedObject<Object> go = new GuardedObject<>();
        gos.put(key, go);
        return go;
    }

    static<K,T> void fireEnvent(K key, T obj) {
        GuardedObject go = gos.remove(key);
        if (go != null) {
            go.onChanged(obj);
        }
    }

    // 获取受保护的对象
    T get(Predicate<T> p) {
        lock.lock();
        try {
            // MESA 模型的管程推荐写法
            while (!p.test(obj)) {
                done.await(timeout, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
        return obj;
    }

    // 事件通知方法
    void onChanged(T obj) {
        lock.lock();
        try {
            this.obj = obj;
            done.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
