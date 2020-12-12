package generics;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/13 12:07 下午
 */
// ReturnGenericType.java
public class ReturnGenericType <T extends Hasf> {
    private T obj;

    public ReturnGenericType(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }

    public static void main(String[] args) {
        ReturnGenericType<Hasf> hf = new ReturnGenericType<>(new Hasf());
        Hasf hasf = hf.get();
    }
}
