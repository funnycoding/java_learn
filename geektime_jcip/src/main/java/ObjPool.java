//import com.sun.org.apache.xml.internal.utils.ObjectPool;
//import java.util.List;
//import java.util.Vector;
//import java.util.concurrent.Semaphore;
//import java.util.function.Function;
//
///**
// * @author XuYanXin
// * @program javaconcurrency_learn
// * @description
// * @date 2020/8/6 11:54 下午
// */
//
//public class ObjPool<T,R> {
//    final List<T> pool;
//    // 用信号量实现限流器
//    final Semaphore sem;
//
//    ObjPool(int size, T t) {
//        pool = new Vector<T>(){}; // 这句怎么理解
//
//        for (int i = 0; i < size; i++) {
//            pool.add(t);
//        }
//        sem = new Semaphore(size);
//    }
//
//    // 利用对象池的对象调用 func
//
//    R exec(Function<T, R> func) {
//        T t = null;
//        sem.acquire();
//        try {
//            t = pool.remove(0);
//            return func.apply(t);
//        }finally {
//            pool.add(t);
//            sem.release();
//        }
//    }
//
//    public static void main(String[] args) {
//        // 创建对象池
//        ObjPool<Long, String> pool = new ObjPool(10, 2);
//        // 通过对象池获取t，之后调用方法
//        pool.exec(t -> {
//            System.out.println(t);
//            return t.toString();
//        });
//    }
//}
