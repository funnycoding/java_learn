package chapter4;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/1 8:59 下午
 */
// 将多个线程安全的类组合成一个线程安全的类
// 包含了一组键盘事件 一组鼠标事件的 添加与移除
public class VisualComponent {
    // 键盘事件监听器列表，使用线程安全的 CopyOnWriteArrayList
    private final List<KeyListener> keyListeners = new CopyOnWriteArrayList<>();
    // 鼠标事件监听器列表，使用线程安全的 CopyOnWriteArrayList
    private final List<MouseListener> mouseListeners = new CopyOnWriteArrayList<>();

    public void addKeyListener(KeyListener listener) {
        keyListeners.add(listener);
    }

    public void addMouseListener(MouseListener listener) {
        mouseListeners.add(listener);
    }

    public void removeKeyListenser(KeyListener listener) {
        keyListeners.remove(listener);
    }

    public void removeMouseListener(MouseListener listener) {
        mouseListeners.remove(listener);
    }
}
