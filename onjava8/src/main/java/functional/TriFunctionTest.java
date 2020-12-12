package functional;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 2:16 下午
 */

public class TriFunctionTest {

    static int testMethod(int i, long l, double d) {
        return 99;
    }

    public static void main(String[] args) {
        // 将testMethod方法引用赋值给接口 TriFunction
        TriFunction<Integer, Long, Double, Integer> tf = TriFunctionTest::testMethod;
        // 使用 Lambda 实现 TriFunction接口
        tf = (i, l, d) -> 12;

        // 匿名内部类实现该接口
        TriFunction<Integer, Long, Double, Integer> triFunction = new TriFunction<Integer, Long, Double, Integer>() {
            @Override
            public Integer apply(Integer integer, Long aLong, Double aDouble) {
                return 99;
            }
        };
    }
}
