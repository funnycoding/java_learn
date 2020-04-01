package chapter4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/1 5:32 下午
 */

// 一个车辆追踪类，可能在多线程环境下对同一个车辆的位置信息进行读取和修改
@ThreadSafe
public class MonitorVehicleTracker {
    @GuardedBy("this")
    private final Map<String, MutablePoint> locations;

    /**
     * 构造 车辆位置信息追踪系统，注意这里没有直接将传入构造函数中的引用赋值给类中的引用，而是经过处理后返回了一个 unmodifiableMap
     *
     * @param locations
     */
    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    /**
     * 根据 车辆的ID 获取 车辆当前的位置信息
     *
     * @param id
     * @return
     */
    public synchronized MutablePoint getLocation(String id) {
        MutablePoint location = locations.get(id);
        //todo  这里为啥要重新构造 MutablePoint 对象而不是直接返回？
        return location == null ? null : new MutablePoint(location);
    }

    /**
     * 更新 指定车辆的位置 由于可能多个线程同时更新一辆车的位置信息，所以该方法需要是线程安全的。
     *
     * @param id
     * @param x
     * @param y
     */
    public synchronized void setLocations(String id, int x, int y) {
        MutablePoint location = locations.get(id);
        if (location == null) {
            throw new IllegalArgumentException("No such Id Car:" + id);
        }
        location.x = x;
        location.y = y;
    }


    private Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
        Map<String, MutablePoint> result = new HashMap<>();

        for (String id : m.keySet()) {
            result.put(id, new MutablePoint(m.get(id)));
        }
        // 返回一个不不可变的 Map
        return Collections.unmodifiableMap(result);
    }
}
