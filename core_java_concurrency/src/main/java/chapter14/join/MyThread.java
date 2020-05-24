package chapter14.join;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/5/18 11:13 上午
 */

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("子线程执行完毕");
    }
}


