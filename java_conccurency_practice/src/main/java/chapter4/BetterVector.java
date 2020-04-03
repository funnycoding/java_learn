package chapter4;

import java.util.Vector;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/1 11:30 下午
 */

// 扩展 Vector 增加一个 若没有则添加的方法 并保持类的线程安全性
public class BetterVector<E> extends Vector<E> {
    // When extending a serializable class, you should redefine serialVersionUID
    // 实现可被序列化的接口就要有这个 serialVersionUID
    static final long serialVersionUID = -3963416950630760754L;

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !contains(x);
        if (absent) {
            add(x);
        }
        return absent;
    }
}
