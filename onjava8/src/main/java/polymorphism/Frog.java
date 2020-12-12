package polymorphism;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/9 5:19 下午
 */

class Characteristic {
    private String s;

    public Characteristic(String s) {
        this.s = s;
        System.out.println("Creating Characteristic " + s);
    }

    protected void dispose() {
        System.out.println("Dispose Characteristic" + s);
    }
}

class Description {
    private String s;

    public Description(String s) {
        this.s = s;
        System.out.println("Creating Description " + s);
    }

    protected void dispose() {
        System.out.println("Dispose Description " + s);
    }

}

class LivingCreature {
    // 顶层父类的类成员先被初始化
    private Characteristic p = new Characteristic("is Alive");
    private Description d = new Description("Basic Living Creature");

    // 随后顶层父类的 构造函数被调用
    public LivingCreature() {
        System.out.println("Living Creature()");
    }

    protected void dispose() {
        System.out.println("Living Creature Dispose");
        p.dispose();
        d.dispose();
    }

}

class Animal extends LivingCreature {
    private Characteristic characteristic = new Characteristic("Has Heart");
    private Description description = new Description("Animal Not Vegetable");

    public Animal() {
        System.out.println("Animal");
    }

    @Override
    protected void dispose() {
        System.out.println("Animal Dispose()");
        characteristic.dispose();
        description.dispose();
        // 调用父类 dispose 方法
        super.dispose();
    }
}

/**
 * 两栖动物
 */
class Amphibian extends Animal {
    private Characteristic characteristic = new Characteristic("can live in water");
    private Description description = new Description("Both water and land");

    public Amphibian() {
        System.out.println("Amphibian()");
    }

    @Override
    protected void dispose() {
        System.out.println("Amphibian Dispose");
        characteristic.dispose();
        description.dispose();
        super.dispose();
    }
}


public class Frog extends Amphibian {
    // 类属性先被初始化
    private Characteristic characteristic = new Characteristic("Croaks");
    private Description description = new Description("Eats Bugs");

    public Frog() {
        System.out.println("Frog");
    }

    @Override
    protected void dispose() {
        System.out.println("Frog Dispose");
        characteristic.dispose();
        description.dispose();
        super.dispose();
    }

    public static void main(String[] args) {
        // 创建一个 Frog 对象  一路向上追溯 最顶层父类是 LivingCreature 类
        Frog frog = new Frog();
        System.out.println("Bye");
        // 开始调用 dispose
        frog.dispose();
    }

}
