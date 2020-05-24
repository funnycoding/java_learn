package chapter14.join;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/5/18 11:13 上午
 */

public class ThreadTest {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            MyThread thread = new MyThread();
            thread.start();
            try {
                // 等待子线程执行完毕
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程执行完毕");
            System.out.println("-------------");
        }
    }
}
