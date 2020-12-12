package reuse;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/26 11:42 上午
 */
// Cartoon.java
class Art {
    Art() {
        System.out.println("父类无参构造");
    }
}

class Drawing extends Art {
    Drawing() {
        System.out.println("子类无参构造");
    }
}

public class Cartoon extends Drawing{

    public static void main(String[] args) {
        Cartoon cartoon = new Cartoon();
    }
}
