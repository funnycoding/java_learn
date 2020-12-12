package chapter1;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/5/19 11:05 上午
 */

public class Widget {
    public synchronized void doSomething() {
        //...
    }
}

 class LoggingWidget extends Widget {
    // 首先调用子类的 doSomething 需要获取锁
    @Override
    public synchronized void doSomething() {
        System.out.println(toString() + ": calling doSomething");
        // 调用父类的 doSomething 又要获取锁 如果锁不能重入则 super.doSomething 永远无法获得 Widget 上的锁，因为子类和父类的方法都需要获取 Widget 的锁，而子类已经先获取了。
        super.doSomething();
    }
}