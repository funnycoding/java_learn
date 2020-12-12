package generics;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/12 11:33 上午
 */

// CountedObject.java
// id 自增的计数类
public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    public long id() {
        return id;
    }

    @Override
    public String toString() {
        return "Counted Object " + id;
    }
}
