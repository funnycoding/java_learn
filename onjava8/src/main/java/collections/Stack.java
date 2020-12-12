package collections;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description 用Deque自己实现一个 Stack 数据结构
 * @date 2020/2/16 2:48 下午
 */

public class Stack<T> {
    private Deque<T> storage = new ArrayDeque<>();

    // 向 storage 中添加元素
    public void push(T v) {
        storage.push(v);
    }

    public T peek() {
        return storage.peek();
    }

    public T pop() {
        return storage.pop();
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }

    // 打印 storage 中的元素信息
    @Override
    public String toString() {
        return storage.toString();
    }
}
