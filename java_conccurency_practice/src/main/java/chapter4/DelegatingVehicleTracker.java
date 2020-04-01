package chapter4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/1 7:49 下午
 */

// 将线程安全委托给 ConcurrentHashMap
public class DelegatingVehicleTracker {
    private final ConcurrentHashMap<String, Point> locations;
    private final Map<String, Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, Point> points) {
        locations = new ConcurrentHashMap<>(points);
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }
    public Map<String, Point> getLocations() {
        return unmodifiableMap;
    }

    public Point getLocations(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (locations.replace(id, new Point(x, y)) == null) {
            throw new IllegalArgumentException("invalid vehicle name: " + id);
        }
    }

    // Alternate version of getLocations (Listing 4.8)
    // 另一种获取车辆位置的方法 , 将当前的locations 复制到一个 HashMap 中
    public Map<String, Point> getLocationsAsStatoc() {
        return Collections.unmodifiableMap(new HashMap<>(locations));
    }
}
