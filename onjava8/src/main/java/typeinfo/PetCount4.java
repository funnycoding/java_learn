package typeinfo;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/4 1:59 下午
 */
// PetCount4.java
public class PetCount4 {
    public static void main(String[] args) {
        // 指定计数的基类是 Pet.class
        TypeCounter counter = new TypeCounter(Pet.class);
        Pets.stream()
                .limit(20)
                .peek(counter::count)
                .forEach(p -> System.out.print(p.getClass().getSimpleName() + " "));

        System.out.println("n" + counter);


    }
}
