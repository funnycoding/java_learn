package chapter3;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/3/25 6:57 下午
 */

// 使用私有构造函数 + 公共工厂方法防止 this 逸出
// SafeListener.java
public class SafeListener {
    private final EventListener listener;

    // 私有的构造函数
    private SafeListener() {
        listener = new EventListener() {
            @Override
            public void onEvent(Event e) {
                doSomething(e);
            }
        };
    }

    // 公共工厂方法用来获取 SafeListener 类实例

    public static SafeListener newInstance(EventSource source) {
        SafeListener safeListener = new SafeListener();
        source.registerListener(safeListener.listener);
        return safeListener;
    }

    void doSomething(Event e) {
    }

    interface EventSource {
        void registerListener(EventListener e);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {
    }
}
