package chapter1;


/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/9 7:27 下午
 */
public class VolatileExample {
    volatile int x = 0;
    volatile boolean v = false;

    public void writer() {
        x += 1;
        v = true;
    }

    public void reader() {
        if (v == true) {
            System.out.println(x);
        }
    }



    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();
        for (int i = 0; i < 100000; i++) {
            example.writer();
        }
    }
}
