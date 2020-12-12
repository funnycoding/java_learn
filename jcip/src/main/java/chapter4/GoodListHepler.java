package chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.jcip.annotations.ThreadSafe;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/1 11:49 下午
 */
// 使用客户端加锁形式保证线程安全的 若没有则添加类
@ThreadSafe
public class GoodListHepler<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    public boolean putIfAbsent(E x) {
        synchronized (list) {
            boolean absent = !list.contains(x);
            if (absent) {
                list.add(x);
            }
            return absent;
        }
    }
}
