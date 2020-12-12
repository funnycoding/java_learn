package chapter4;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/1 2:06 下午
 */

// 简单的线程安全类，使用 Java 监视器模式（synchronized 监视器锁）
// Counter.java
@ThreadSafe
public class Counter {
    @GuardedBy("this")
    private long value = 0;

    // 保证 value 的可见性
    public synchronized long getValue() {
        return value;
    }

    // 保证 ++value 成为一组原子操作
    public synchronized long increment() {
        if (value == Long.MAX_VALUE) {
            throw new IllegalArgumentException("counter Over flow");
        }
        return ++value;
    }
}
