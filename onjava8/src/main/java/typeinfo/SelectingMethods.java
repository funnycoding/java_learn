package typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/4 6:09 下午
 */
// SelectingMethods.java
class MethodSelector implements InvocationHandler {

    // 持有的被代理的对象
    private Object proxied;

    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 对特定代理方法进行了增强
        if (method.getName().equals("interesting")) {
            System.out.println("Proxy detected the interesting method");
        }
        return method.invoke(proxied, args);
    }
}

interface SomeMethods {
    void boring1();

    void boring2();

    void interesting(String arg);

    void boring3();
}

class Implementation implements SomeMethods {

    @Override
    public void boring1() {
        System.out.println("boring1");
    }

    @Override
    public void boring2() {
        System.out.println("boring2");
    }

    @Override
    public void interesting(String arg) {
        System.out.println("interesting " + arg);
    }

    @Override
    public void boring3() {
        System.out.println("boring3");
    }
}


public class SelectingMethods {
    public static void main(String[] args) {
        SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(
                SomeMethods.class.getClassLoader(),
                new Class[]{SomeMethods.class},
                new MethodSelector(new Implementation()));

        proxy.boring1();
        proxy.boring2();
        proxy.interesting("bobo");
        proxy.boring3();
    }
}
