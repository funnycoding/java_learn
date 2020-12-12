package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 10:10 下午
 */

class Egg2 {
    protected class Yolk {
        public Yolk() {
            System.out.println("Egg2.Yolk()");
        }

        public void f() {
            System.out.println("Egg2.Yolk.f()");
        }
    }
    // 首先初始化类变量，调用 Yolk构造函数
    private Yolk y = new Yolk();

    public Egg2() {
        System.out.println("New Egg2");
    }

    //赋值
    public void insertYolk(Yolk yy) {
        this.y = yy;
    }
    // 调用 f() 函数
    public void g() {
        y.f();
    }
}

public class BigEgg2 extends Egg2{
    public class Yolk extends Egg2.Yolk {
        public Yolk() {
            System.out.println("BigEgg2.Yolk()");
        }

        @Override
        public void f() {
            System.out.println("BigEgg2.Yolk.f()");
        }

    }

    public BigEgg2() {
        insertYolk(new Yolk());
    }

    public static void main(String[] args) {
        BigEgg2 bigEgg2 = new BigEgg2();
        bigEgg2.g();
    }
}
