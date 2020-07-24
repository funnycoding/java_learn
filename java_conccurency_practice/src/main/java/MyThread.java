/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/7/22 5:25 下午
 */

public class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println("MyThread 类 实现了 Runnable 接口的 Run 方法中的输出");
    }
}
