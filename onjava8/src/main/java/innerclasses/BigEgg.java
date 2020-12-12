package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 9:52 下午
 */

class Egg {
    private Yolk y;

    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk()");
        }
    }

    Egg() {
        System.out.println("New Egg()");
        // 初始化 Yolk 对象
        y = new Yolk();
    }
}

public class BigEgg extends Egg{
    // 重新定义一个 Yolk Override
    public class Yolk {
        public Yolk() {
            System.out.println("Big Egg Yolk()");
        }
    }

    public static void main(String[] args) {
        BigEgg bigEgg = new BigEgg();
    }

}
