package generics;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/13 11:34 上午
 */

// Manipulation.java
class Manipulator<T> {
    private T obj;

    public Manipulator(T obj) {
        this.obj = obj;
    }

    // 编译器会抛出异常，找不到 f() 方法
    public void manipulate() {
        System.out.println(obj);
        //System.out.println(obj.f()); // 找不到 f 方法
    }
}


// generics/Manipulation.java
// {WillNotCompile}
public class Manipulation {
    public static void main(String[] args) {
        Hasf hf = new Hasf();
        Manipulator<Hasf> manipulator = new Manipulator<Hasf>(hf);
        manipulator.manipulate();
    }
}
