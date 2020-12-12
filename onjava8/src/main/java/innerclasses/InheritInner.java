package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 9:42 下午
 */


class WithInner {
    class Inner {

    }
}

public class InheritInner extends WithInner {
    //- InheritInner() {} // Won't compile 无法被编译
/*    InheritInner(WithInner withInner) {
        withInner.super();
    }*/

    public InheritInner() {
    }

  /*  public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }*/
}
