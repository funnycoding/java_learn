package chapter3;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/3/24 9:54 下午
 */
// ThisEscape.java
public class ThisEscape {
    // 这里构造 ThisEscape 对象实际上是为了构造一个实现了 EventListener 的实例
    // 但还是因为这个类是 ThisEscape 的内部类，所以匿名内部类隐式持有外部类的引用
    // 相当于 ThisEscape 实例本身也被发布了。
    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            @Override
            public void onEvent(Event e) {
                doSomething(e);
            }
        });
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

