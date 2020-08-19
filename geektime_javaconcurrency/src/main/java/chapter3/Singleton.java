package chapter3;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/8/19 10:27 下午
 */

public class Singleton {
    private static Singleton singleton;
    // 私有化构造函数
    private Singleton() {

    }
    // 单例的获取 Singleton 实例的方法
    public   static Singleton getInstance() {
        // 第一次检查
        if (singleton == null) {
            synchronized (Singleton.class){
                // 获取锁后的二次检查
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
