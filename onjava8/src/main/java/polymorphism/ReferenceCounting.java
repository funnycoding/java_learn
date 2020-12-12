package polymorphism;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description 引用计数
 * @date 2020/2/9 8:21 下午
 */

class Shared {
    // 引用计数字段
    private int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;

    public Shared() {
        System.out.println("Counting " + this);
    }

    public void addRef() {
        System.out.println("开始增加 Ref,当前 Ref: " + refcount);
        refcount++;
    }

    protected void dispose() {
        if (--refcount == 0) {
            System.out.println("Disposing " + this);
        }
    }

    @Override
    public String toString() {
        return "Shared " + id;
    }
}

class Composing {
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;

    public Composing(Shared shared) {
        System.out.println("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dispose() {
        System.out.println("disposing " + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing " + id;
    }
}


public class ReferenceCounting {
    public static void main(String[] args) {
        // 首先需要调用构造函数
        Shared shared = new Shared();

        Composing[] composings = {
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
        };

        for (Composing c : composings) {
            c.dispose();
        }
    }

}
