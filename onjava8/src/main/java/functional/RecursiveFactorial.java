package functional;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/17 4:13 下午
 */
// functional/RecursiveFactorial.java
public class RecursiveFactorial {
    // 定义了一个 入参和返回参数都是 int 的接口
    static IntCall fact;

    public static void main(String[] args) {
        // 使用 Lambda 递归计算 n的阶乘
        fact = n -> {
            if (n == 0) {
                System.out.print("本次入参 n 为0 ,fact.call 返回 1");
                return 1;
            } else {
                System.out.println("开始递归调用，本次n的值为: " + n);
                return n * fact.call(n - 1);
            }
        };

        for (int i = 0; i < 10; i++) {
            System.out.println(", fact.call 最终数值为:"+ fact.call(i));
        }
    }
}
