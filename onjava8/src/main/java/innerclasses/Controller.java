package innerclasses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 7:49 下午
 */

public class Controller {
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event e) {
        eventList.add(e);
    }

    public void run() {
        while (eventList.size() > 0) {
            for (Event e : new ArrayList<>(eventList)) { // 重新创建队列是为了避免 remove的时候导致并发修改异常吧
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}
