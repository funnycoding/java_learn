package functional;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description 定义一个接口 分别
 * @date 2020/2/17 1:32 下午
 */

// functional/Strategy.java
interface Strategy {
    String approach(String msg);
}

class Soft implements Strategy {
    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}

// 该类的方法签名与返回值与接口相同的方法，但是并没有实现接口，方法名称也不同
class Unrelated {
    static String twice(String msg) {
        return msg + " " + msg;
    }
}

public class Strategize {
    // 持有接口引用 用来指向其实现类
    Strategy strategy;
    String msg;

    // 初始化默认策略
    public Strategize(String msg) {
        strategy = new Soft(); // 默认策略是 Soft 对 Strategy 接口的是实现
        this.msg = msg;
    }

    // 打印 approach() 函数的输出
    void communicate() {
        System.out.println(strategy.approach(msg));
    }

    // 给策略引用重新赋值对象，实现策略的切换
    void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        // 初始化一个元素是策略对象的数组，第一个元素是一个实现 Strategy 接口的匿名内部类
        // 第二个元素是 使用 Lambda 语法实现的匿名内部类
        // 第三个是 使用方法引用，将 Unrelated 类的 twice 方法引用赋值给 接口 因为 twice 方法的方法签名与返回值与 接口定义的 approach 方法相同
        Strategy[] strategies = {
                new Strategy() {
                    @Override
                    public String approach(String msg) {
                        return msg.toUpperCase();
                    }

                    @Override
                    public String toString() {
                        return "匿名对象策略";
                    }
                }, // 第一个元素: 实现了 Strategy 接口的匿名内部类
                msg -> msg.substring(0, 5), // 第二种 Lambda表达式,入参是 msg ，对入参的处理是截取 [0,5] 的一个子串
                // 第三种 方法引用，将 Unrelated 的方法引用 赋值给 Strategy 接口，只要方法的返回值与方法签名与接口中的抽象方法一直，就可以进行方法引用的赋值，实现行为的绑定
                Unrelated::twice,

        };

        Strategize s = new Strategize("Hello there");
        // 输出默认Strategy -> Soft 中的实现
        s.communicate();
        // 遍历策略数组，分别打印不同策略实现的 approach 方法
        for (Strategy newStrategy : strategies) {
            System.out.println("开始更改策略对象，当前策略对象" + newStrategy);
            s.changeStrategy(newStrategy);
            s.communicate();
        }
    }
}
