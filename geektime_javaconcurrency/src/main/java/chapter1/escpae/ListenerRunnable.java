package chapter1.escpae;

import java.util.List;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/10 12:13 下午
 */

public class ListenerRunnable implements Runnable {
    private EventSource<EventListener> source;

    public ListenerRunnable(EventSource<EventListener> source) {
        this.source = source;
    }


    @Override
    public void run() {
        List<EventListener> listeners = null;
        try {
            listeners = this.source.retrieveListener();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (EventListener listener : listeners) {
            listener.onEvent(new Object());
        }
    }
}
