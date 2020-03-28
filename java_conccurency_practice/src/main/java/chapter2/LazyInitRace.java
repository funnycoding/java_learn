package chapter2;

import net.jcip.annotations.NotThreadSafe;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/3/20 4:14 下午
 */

// 一个典型的 线程不安全的 最简单的单例模式的实现
//LazyInitRace.java
class ExpensiveObject {

}

@NotThreadSafe
public class LazyInitRace {
    // 并不直接初始化，而是当真正使用的时候再对这个引用进行初始化
    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null) {
            instance = new ExpensiveObject();
        }
        return instance;
    }
}

