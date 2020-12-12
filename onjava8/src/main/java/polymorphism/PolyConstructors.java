package polymorphism;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/9 9:15 下午
 */

class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }

    public Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    public RoundGlyph(int radius) {
        this.radius = radius;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    // 这里子类重写了父类的 draw()方法，父类的构造器中又调用了这个方法，于是 创建子类对象时构造器调用的方法涉及到了多态。
    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}


public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
