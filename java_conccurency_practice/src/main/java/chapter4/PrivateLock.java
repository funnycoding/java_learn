package chapter4;

import apple.laf.JRSUIConstants.Widget;
import net.jcip.annotations.GuardedBy;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/1 5:05 下午
 */

// 通过私有对象作为锁保护对象的状态
// PrivateLock.java
public class PrivateLock {
    // 一个私有的对象，将这个对象作为一把锁
    private final Object myLock = new Object();

    @GuardedBy("myLock")
    Widget widget;

    void someMethod() {
        synchronized (myLock) {
            // 访问或修改 widget 的状态
        }
    }
}
