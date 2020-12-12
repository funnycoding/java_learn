package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 3:08 下午
 */

public class Parcel11 {
    // 嵌套类1
    private static class ParcelContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected static final class ParcelDestination implements Destination {
        private String label;

        public ParcelDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }

        // Nested classes can contain other static elements:
        // 嵌套类可以持有其他静态的元素
        public static void f() { }

        static int x = 10;

        static class AnotherLevel {
            public static void f(){}

            static int anotherX = 10;
        }
    }

    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    public static Contents contents() {
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents contents = contents();
        Destination aa = destination("aa");
        System.out.println(contents.value());
        System.out.println(aa.readLabel());
    }

}
