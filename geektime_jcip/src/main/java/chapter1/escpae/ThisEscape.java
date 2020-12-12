package chapter1.escpae;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/10 12:12 下午
 */

/**
 * this 隐式逸出的发生地
 */
public class ThisEscape {
    public final int id;
    public final String name;

    public ThisEscape(EventSource<EventListener> source) {
        id = 1;
        source.registerListener(new EventListener() {
            public void onEvent(Object object) {
                System.out.println("id: " + ThisEscape.this.id);
                System.out.println("name: " + ThisEscape.this.name);
            }
        });

        try {
            Thread.sleep(1000); // 调用sleep模拟其他耗时的初始化操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        name = "Ahri";
    }
}
