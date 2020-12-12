package typeinfo;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/4 5:39 下午
 */
// typeinfo/SimpleProxyDemo.java
interface Interface {
    void doSomething();

    void somethingElse(String arg);
}

class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}


class SimpleProxy implements Interface {
    // 真实要调用的对象
    private Interface proxied;

    SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("代理类调用真实类方法");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("代理类调用真实类带参方法: " + arg);
        proxied.somethingElse(arg);
    }
}


public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
