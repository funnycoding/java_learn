package chapter1.escpae;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/10 12:13 下午
 */

public class EventSource<T> {
    private final List<T> eventListeners;

    public EventSource() {
        eventListeners = new ArrayList<>();
    }

    public synchronized void registerListener(T eventListener) {
        this.eventListeners.add(eventListener);
        // 唤醒等待重新注册监听器的线程
        this.notifyAll();
    }

    /**
     * 重新注册 Listener
     *
     * @return
     * @throws InterruptedException
     */
    public synchronized List<T> retrieveListener() throws InterruptedException {
        List<T> dest = null;
        if (eventListeners.size() <= 0) {
            this.wait();
        }
        dest = new ArrayList<>(eventListeners.size());
        dest.addAll(eventListeners);
        return dest;
    }
}
