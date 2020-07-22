/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/7/22 5:25 下午
 */

public class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println("子线程："+Thread.currentThread().getName());
    }
}
