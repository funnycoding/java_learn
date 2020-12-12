package arrays;

import static arrays.ArrayShow.show;

import java.util.Arrays;
import onjava.Rand.StringGen;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/9 9:12 下午
 */
// ParallelPrefix2.java
public class ParallelPrefix2 {
    public static void main(String[] args) {
        // 生成8个长度为1个的数组
        String[] strings=new StringGen(1).array(8);
        show(strings);
        // 元素相加
        Arrays.parallelPrefix(strings,(a,b) -> a + b);
        show(strings);
    }
}
