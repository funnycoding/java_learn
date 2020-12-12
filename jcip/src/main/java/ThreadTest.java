/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/7/22 4:53 下午
 */

public class ThreadTest {
    public static void main(String[] args) {
        System.out.println("主线程："+Thread.currentThread().getName());
        // 两种不同的启动新线程的方法
        new Thread(new MyThread()).start();
        new MyThread2().start();
        new MyThread().run();
    }
}
