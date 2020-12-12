package innerclasses;

import java.time.Duration;
import java.time.Instant;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 7:41 下午
 */

public abstract class Event {
    private Instant eventTime;
    protected final Duration delayTime;

    public Event(long millisecondDelay) {
        delayTime = Duration.ofMillis(millisecondDelay);
        start();
    }

    public void start() { // Allows restarting
        eventTime = Instant.now().plus(delayTime);
    }

    public boolean ready() {
        return Instant.now().isAfter(eventTime);
    }

    public abstract void action();
}
