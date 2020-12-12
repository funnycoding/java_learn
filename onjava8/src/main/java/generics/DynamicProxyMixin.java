package generics;

import static onjava.Tuple.tuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import onjava.Tuple2;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/3/16 6:48 下午
 */

// generics/DynamicProxyMixin.java
// 使用动态代理来完成混型功能增强，代码比较复杂，值得研究学习
class MixinProxy implements InvocationHandler {
    Map<String, Object> delegatesByMethod;

    @SuppressWarnings("unchecked")
    MixinProxy(Tuple2<Object, Class<?>>... pairs) {
        delegatesByMethod = new HashMap<>();
        // 这里意思是变参函数可以直接使用 for-in 语法遍历？
        for (Tuple2<Object, Class<?>> pair : pairs) {
            // 获取 a2 对象的方发表
            for (Method method : pair.a2.getMethods()) {
                String methodName = method.getName();
                // 将a2中的方法存入 HashMap 中
                if (!delegatesByMethod.containsKey(methodName)) {
                    delegatesByMethod.put(methodName, pair.a1);
                }
            }
        }
    }

    // 这个方法没看太懂，是调用代理类的方法吗
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object delegate = delegatesByMethod.get(methodName);
        return method.invoke(delegate, args);
    }


    @SuppressWarnings("unchecked")
    public static Object newInstance(Tuple2... pairs) {
        Class[] interfaces = new Class[pairs.length];

        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = (Class) pairs[i].a2;
        }
        // 获取代理接口的类加载器
        ClassLoader cl = pairs[0].a1.getClass().getClassLoader();
        // 获取代理类实例对象
        return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
    }
}

public class DynamicProxyMixin {
    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(
                tuple(new BasicImp(), Basic.class),
                tuple(new TimeStampedImp(), TimeStamped.class),
                tuple(new SerialNumberedImp(), SerialNumbered.class));

        Basic b = (Basic) mixin;
        TimeStamped t = (TimeStamped) mixin;
        SerialNumbered s = (SerialNumbered) mixin;

        b.set("Hello:");

        // 获取 Basic 中持有的 value
        System.out.println(b.get());
        // 获取时间戳
        System.out.println(t.getStamp());
        // 或许序列号 从 1 开始自增
        System.out.println(s.getSerialNumbered());
    }
}
