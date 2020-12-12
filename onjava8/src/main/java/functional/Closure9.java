package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 4:30 下午
 */

public class Closure9 {
    Supplier<List<Integer>> makeFun() {
        List<Integer> list = new ArrayList<>();
        //list = new ArrayList<>();
        return () -> list;
    }
}
