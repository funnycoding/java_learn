package generics;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/13 3:23 下午
 */
// GenericHolder2.java
public class GenericHolder2<T> {
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        GenericHolder2<String>  strHolder = new GenericHolder2<>();
        strHolder.setObj("Item");
        String s = strHolder.getObj();
    }
}
