package generics;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/13 3:18 下午
 */
// SimpleHolder.java
public class SimpleHolder {
    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        SimpleHolder sh = new SimpleHolder();
        sh.setObj("Item");
        String obj = (String) sh.getObj();
    }
}
