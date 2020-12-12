package generics;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/11 2:16 上午
 */
// GenericHolder.java
public class GenericHolder<T> {
    // 相当于定义一个 Object 引用
    private T a;

    public GenericHolder() {
    }

    // 对类型参数的赋值 以及对应的获取方法
    public GenericHolder(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void set(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        GenericHolder<Automobile> h3 = new GenericHolder<>();
        h3.set(new Automobile()); // 此处编译器会对 Set 方法做类型校验 如果不是 Automobile 类 ，则报错
        Automobile a = h3.getA(); // 无需进行 Class Cast，编译器知道 GnericHolder 中的 T 就是 Automobile类型
        //h3.set("Not an Automobile"); // 报错
        //h3.set(1);  // 报错
    }
}
