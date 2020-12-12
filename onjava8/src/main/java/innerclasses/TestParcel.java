package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/12 11:03 下午
 */



class Parcel4 {
    private class PContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    // 不可变类
    protected final class PDestination implements Destination {
        private String label;

        public PDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    // 返回接口引用，实际返回的是实现接口的某个具体子类，但是外观是顶层接口
    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }

}


public class TestParcel {
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents contents = p.contents();
        Destination aaa = p.destination("aaa");
        // Illegal -- can't access private class:
        //- Parcel4.PContents pc = p.new PContents(); 无法使用 p.new PContents 来创建对应的对象 因为该类是私有内部类

    }
}
