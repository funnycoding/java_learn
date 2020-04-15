package chapter6;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/14 10:13 上午
 */
// Timer 因抛出异常错误结束的情景
public class OutOfTime {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始执行");
        Timer timer = new Timer();
        // 执行到这里时 Timer因为抛出了 未预料的异常，之后的代码也无法继续进行了
        timer.schedule(new ThrowTask(),1);
        SECONDS.sleep(1);
        timer.schedule(new ThrowTask(),1);
        SECONDS.sleep(5);
    }

    static class ThrowTask extends TimerTask {
        @Override
        public void run() {
            throw new RuntimeException();
        }
    }
}
