package arrays;

import static arrays.ArrayShow.show;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/6 11:00 下午
 */
// arrays/CollectionComparison.java
class BerylliumSphere {
    private static long counter;
    private final long id = counter++;


    @Override
    public String toString() {
        return "Sphere " + id;
    }
}

public class CollectionComparison {
    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[10];

        for (int i = 0; i < 5; i++) {
            spheres[i] = new BerylliumSphere();
        }
        // Arrays.toString
        show(spheres);
        System.out.println(spheres[4]);
        System.out.println("----- List ----");
        ArrayList<BerylliumSphere> sphersList = Suppliers.create(ArrayList::new, BerylliumSphere::new, 5);
        System.out.println(sphersList);
        System.out.println(sphersList.get(4));

        int[] integers = {0, 1, 2, 3, 4, 5};
        show(integers);
        System.out.println(integers[4]);

        System.out.println("--- Int List ---");
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        intList.add(97);
        System.out.println(intList);
        System.out.println(intList.get(4));
    }
}
