package chaoter3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/8/16 9:13 下午
 */

// 路由信息数据类
public class Router {


    private final String ip;
    private final Integer port;
    private final String iface;

    public Router(String ip, Integer port, String iface) {
        this.ip = ip;
        this.port = port;
        this.iface = iface;
    }

    // 重写 equals 方法 需要对比三个字段完全一致才能认定两个路由对象一致
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Router) {
            Router r = (Router) obj;
            return iface.equals(r.iface) &&
                    ip.equals(r.ip) &&
                    port.equals(r.port);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port, iface);
    }

    // 路由表信息

    public class RouterTable {
        // key:接口名
        // Value:路由集合
        ConcurrentHashMap<String, CopyOnWriteArraySet<Router>> rt = new ConcurrentHashMap<>();

        // 根据接口名获取路由表
        public Set<Router> getRouter(String iface) {
            return rt.get(iface);
        }

        // 删除路由
        public void remove(Router router) {
            Set<Router> set = rt.get(router.iface);
            if (set != null) {
                set.remove(router);
            }
        }

        // 增加路由 todo 这里 ConcurrentHashMap 的 computeIfAbsent 需要看源码学习一下
        public void add(Router router) {
            Set<Router> set = rt.computeIfAbsent(router.iface, r -> new CopyOnWriteArraySet<>());
            set.add(router);
        }
    }

    static class ThreadId {
        static final AtomicLong nextId = new AtomicLong(0);
        // 定义 ThreadLocal 变量
        static final ThreadLocal<Long> tl = ThreadLocal.withInitial(() -> nextId.getAndIncrement());

        // 此方法为每个线程分配一个唯一的ID
        static long get() {
            return tl.get();
        }
    }

    static class SafeDateFormat {
        // 定义ThreadLocal变量
        static final ThreadLocal<DateFormat> tl = ThreadLocal
                .withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        static DateFormat get() {
            return tl.get();
        }
        // 不同线程执行下面代码返回的 DateFormat 对象不同
        DateFormat dateFormat = SafeDateFormat.get();
    }

    // 自己实现一个ThreadLocal类
    class MyThreadLocal<T> {
        Map<Thread, T> locals = new ConcurrentHashMap<>();

        // 获取线程变量
        T get() {
            return locals.get(Thread.currentThread());
        }

        // 设置线程变量
        void set(T t) {
            locals.put(Thread.currentThread(), t);
        }
    }

    public static void main(String[] args) {
        DateFormat dateFormat = SafeDateFormat.get();
    }

}
