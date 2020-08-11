import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/8/8 4:41 下午
 */

public class CachedData {
    Object data;
    volatile boolean cacheValid;
    final ReadWriteLock rwl = new ReentrantReadWriteLock();

    // 读锁
    final Lock r = rwl.readLock();

    // 写锁
    final Lock w = rwl.writeLock();

    void processCachedData() {
        // 获取读锁
        r.lock();
        if (!cacheValid) {
            // 释放读锁，因为不允许锁升级
            r.unlock();

            // 获取写锁
            w.lock();
            try {
                // 再次检查缓存状态
                if (!cacheValid) {
                    //data = ...  获取数据
                    cacheValid = true;
                }
                // 释放写锁前，锁降级为读锁
                r.lock(); // ①
            }finally {
                w.unlock();
            }
            // 此处线程仍然持有读锁
            try {
                // use(data) 使用数据
            }finally {
                r.unlock();
            }
        }
    }
}
