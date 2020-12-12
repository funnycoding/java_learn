package arrays;

import java.util.Arrays;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/7 5:11 下午
 */
// arrays/MultidimensionalObjectArrays.java
public class MultidimensionalObjectArryas {
    public static void main(String[] args) {
        BerylliumSphere[][] spheres = {
                {new BerylliumSphere(), new BerylliumSphere()},
                {new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere()},
                {new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere()},
        };
        System.out.println(Arrays.deepToString(spheres));
    }
}
