package chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/1 11:41 下午
 */

// 非线程安全的 "若没有则添加" 类
public class BadListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !list.contains(x);
        if (absent) {
            list.add(x);
        }
        return absent;
    }
}
