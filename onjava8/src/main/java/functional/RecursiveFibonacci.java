package functional;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description 使用 Lambda 来完成 斐波那契数列
 * @date 2020/2/17 4:23 下午
 */

// RecursiveFibonacci.java
public class RecursiveFibonacci {
    // 入参是int,出参也是int的函数式接口。
    IntCall fib;

    // 类的构造函数，使用 Lambda 表达式实现 IntCall 的call()函数
    public RecursiveFibonacci() {
     /*   fib = n -> n == 0 ? 0 :
                n == 1 ? 1 :
                        fib.call(n - 1) + fib.call(n - 2);*/

        // if - else 版 斐波那契数列生成函数
        fib = n -> {
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            } else {
                return fib.call(n - 1) + fib.call(n - 2);
            }
        };

    }

    // 调用生成斐波那契数列的函数 ，这层封装只是为了更强的语义性，直接调用 fib.call 也是一样的效果
    int generatorFibonacci(int n) {
        return fib.call(n);
    }

    public static void main(String[] args) {
        RecursiveFibonacci rf = new RecursiveFibonacci();
        for (int i = 0; i <= 10; i++) {
            System.out.println("10以内的斐波那契数列，i = " + i+", 结果: " + rf.generatorFibonacci(i));
        }
    }
}
