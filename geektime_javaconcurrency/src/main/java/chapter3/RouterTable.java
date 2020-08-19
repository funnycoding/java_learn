package chapter3;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import sun.font.TextRecord;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description 使用 volatile 关键字实现的 Balking 模式的 路由表类
 * @date 2020/8/19 10:05 下午
 */
// 路由表信息
public class RouterTable {
    // Key:接口名
    // Value: 路由集合
    ConcurrentHashMap<String, CopyOnWriteArraySet<Router>> rt = new ConcurrentHashMap<>();

    // 路由表是否发生变化的状态判断 flag
    volatile boolean changed;

    // 将路由表写入本地文件的线程池
    ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();

    // 启动定时任务，将变更后的路由表写入本地文件
    public void startLocalServer() {
        ses.scheduleWithFixedDelay(() ->
                autoSave(), 1, 1, TimeUnit.SECONDS);
    }

    // 将路由表保存到本地文件的业务逻辑
    void autoSave() {
        if (!changed) {
            return;
        }
        changed = false;
        // 将路由表写入本地文件，省略其方法实现
        //this.save2Local();
    }

    // 删除路由
    public void remove(Router router) {
        CopyOnWriteArraySet<Router> set = rt.get(router.iface);

        if (set != null) {
            set.remove(router);

            // 此时路由表已经发生变化
            changed = true;
        }
    }

    // 增加路由
    public void add(Router router) {
        Set<Router> set = rt.computeIfAbsent(router.iface, r -> new CopyOnWriteArraySet<>());
        set.add(router);
        // 路由表已经发生变化
        changed = true;
    }
}
