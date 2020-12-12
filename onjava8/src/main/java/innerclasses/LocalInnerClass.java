package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 10:36 下午
 */

interface Counter {
    int next();
}

public class LocalInnerClass {
    private int count = 0;

    Counter getCounter(final String name) {
        // 创建一个局部内部类
        class LocalCounter implements Counter {
            public LocalCounter() {
                System.out.println("LocalCounter()");
            }

            @Override
            public int next() {
                System.out.print("c1" + name); // 访问final类型的入参

                return count++; // 操作外围类参数
            }
        }
        // 返回局部内部类对象
        return new LocalCounter();
    }

    // 用匿名内部类来实现一遍
    Counter getCounterWithAnony(final String name) {
        return new Counter() {
            // 匿名内部类没有构造函数，仅类实例初始化
            {
                System.out.println("匿名内部类 Counter()");
            }

            @Override
            public int next() {
                System.out.print(name);
                return count++;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter c1 = lic.getCounter("Local inner"),
                c2 = lic.getCounterWithAnony("Anonymous inner");

        for (int i = 0; i < 5; i++) {
            System.out.println(c1.next());
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(c2.next());
        }
    }
}
