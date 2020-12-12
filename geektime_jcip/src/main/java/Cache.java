import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/8/8 1:03 下午
 */

public class Cache<K,V> {
    final Map<K, V> m = new HashMap<>();
    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    // 读锁
    final Lock r = rwl.readLock();
    // 写锁
    final Lock w = rwl.writeLock();
    V get(K key) {
        V v = null;
        // 读缓存
        r.lock();
        try {
            v = m.get(key);
        }finally {
            r.unlock();
        }
        // 如果缓存中存在对应数据，直接返回
        if (v != null) {
            return v;
        }
        // 缓存中不存在，查询数据库
        w.lock();
        try {
            // 再次验证数据是否存在，因为数据可能已经被更新
            v = m.get(key);
            if (v == null) {
                // 查询数据库  v=省略代码
                //将查询出的数据放入缓存
                m.put(key, v);
            }
        }finally {
            w.unlock();
        }
        return v;
    }
}
