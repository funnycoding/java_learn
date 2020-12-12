package arrays;

import static arrays.ArrayShow.show;

import java.util.Arrays;
import onjava.Rand;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/9 10:42 上午
 */
// arrays/ModifyExisting.java
public class ModifyExisting {
    public static void main(String[] args) {
        double[] da = new double[7];
        Arrays.setAll(da,new Rand.Double()::get);
        show(da);
        // 遍历数组并将每个元素都缩小100倍
        Arrays.setAll(da, n -> da[n] / 100); // [1]
        show(da);
    }
}
