package arrays;

import static arrays.ArrayShow.show;

import java.util.Arrays;
import onjava.Count;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/9 9:05 下午
 */
//ParallelPrefix1.java
public class ParallelPrefix1 {
    public static void main(String[] args) {
        int[] nums = new Count.Pint().array(10);
        show(nums);
        // 0 - 9 求和
        System.out.println(Arrays.stream(nums).reduce(Integer::sum).getAsInt());
        Arrays.parallelPrefix(nums,Integer::sum);
        show(nums);
        // 0 - 5 求和
        System.out.println(Arrays.stream(new Count.Pint().array(6)).reduce(Integer::sum).getAsInt());
    }
}
