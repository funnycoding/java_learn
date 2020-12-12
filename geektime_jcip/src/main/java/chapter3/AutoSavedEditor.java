package chapter3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/8/19 12:04 下午
 */

public class AutoSavedEditor {
    // 文件是否被修改过
    boolean changed = false;
    // 定时任务线程池
    ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();

    // 定时自动执行保存
    void startAutoSave() {
        ses.scheduleWithFixedDelay(() -> autosave(), 5, 5, TimeUnit.SECONDS);
    }

    private void autosave() {
        // 如果没有修改，则快速返回
        if (!changed) {
            return ;
        }
        changed = false;
        // 执行存盘操作，省略具体逻辑
    }

    // 编辑操作
    void edit() {
        // 省略具体逻辑
        changed = true;
    }
}
