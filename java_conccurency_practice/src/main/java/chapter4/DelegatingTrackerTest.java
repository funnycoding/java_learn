package chapter4;

import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description 对使用委托的车辆追踪器进行测试
 * @date 2020/6/6 10:12 下午
 */
@Slf4j
public class DelegatingTrackerTest {
    /**
     * 测试思路：
     * 1. 初始化一组数据
     * 2. 使用多个线程对其进行并发的访问，有的修改，有的读取
     * 测试目的：
     * 1. 测试返回的实时却可能导致不一致的车辆位置视图和不发生变化导致数据不是最新的视图之间区别
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        //1. 初始化 DelegatingVehicleTracker，需要数据：一个 Map<String,Points> 作为初始坐标
        DelegatingVehicleTracker tracker = new DelegatingVehicleTracker(initPoints());
        log.info("初始化车辆位置: {}", tracker.getLocations());
        // 这时候有几个线程开始操作这个监视器了:
        Runnable w1 = () -> {
            log.info("{} 线程 修改了 Car1的坐标 1 -> 11开始", Thread.currentThread().getName());
            for (int i = 0; i <10 ; i++) {
                tracker.setLocation("Car"+i, i*10, i*10);
            }
            log.info("{} 线程 修改了 Car1的坐标 1 -> 11结束", Thread.currentThread().getName());
        };


        Thread t1 = new Thread(w1, "Write-1");
        log.info("{} 线程 开始获取车辆状态", Thread.currentThread().getName());
        // 此时进行线程切换，让t1线程修改车辆位置
        t1.start();
        t1.join();
        log.info("{} 线程 打印 unmodifiableMap : {}", Thread.currentThread().getName(), tracker.getLocations());
        log.info("{} 线程 打印 Collections.unmodifiableMap(new HashMap<>(locations)): {}",
                Thread.currentThread().getName(), tracker.getLocationsAsStatic());
    }


    /**
     * 初始化车辆坐标的方法，添加一组原始数据
     *
     * @return HashMap<String, Point>
     */
    public static HashMap<String, Point> initPoints() {
        HashMap<String, Point> carPoints = new HashMap<>();
        for (int i = 0; i <20; i++) {
            carPoints.put("Car"+i, new Point(i, i));
        }
        return carPoints;
    }
}
