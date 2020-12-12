package chapter1.escpae;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/10 1:13 下午
 */

/**
 * 不会导致 this 隐式逸出的安全的类
 */
public class SafeConstruct {
    public final int id;
    public final String name;
    EventListener listener;

    private SafeConstruct() {
        id = 1;
        listener = new EventListener() {
            public void onEvent(Object object) {
                System.out.println("id: " + SafeConstruct.this.id);
                System.out.println("name: " + SafeConstruct.this.name);
            }
        };

        try {
            Thread.sleep(1000); // 调用sleep模拟其他耗时的初始化操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        name = "Ahri";
    }

    public static SafeConstruct getInstance(EventSource<EventListener> source) {
        SafeConstruct thisEscape = new SafeConstruct();
        source.registerListener(thisEscape.listener);
        return thisEscape;
    }
}


