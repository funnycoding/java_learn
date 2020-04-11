package chapter1.escpae;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/10 12:31 下午
 */

/**
 * 一个模拟 this 引用逸出的例子
 */
public class ThisEscapeTest {
    public static void main(String[] args) {
        EventSource<EventListener> source = new EventSource<>();
        ListenerRunnable listenerRunnable = new ListenerRunnable(source);
        Thread thread = new Thread(listenerRunnable);
        thread.start();
        SafeConstruct thisEscape = SafeConstruct.getInstance(source);
    }
}
