package functional;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description 自己定义一个三个参数的函数式接口
 * @date 2020/2/18 2:14 下午
 */

// 自定义的函数式接口
@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
