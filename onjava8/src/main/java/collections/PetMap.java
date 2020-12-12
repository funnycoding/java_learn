package collections;



import java.util.HashMap;
import pets.Cat;
import pets.Dog;
import pets.Hamster;
import pets.Pet;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/16 4:41 下午
 */

public class PetMap {
    public static void main(String[] args) {
        HashMap<String, Pet> petMap = new HashMap<>();
        petMap.put("My Cat", new Cat("Molly"));
        petMap.put("My Dog", new Dog("Ginger"));
        petMap.put("My Hamster", new Hamster("Bosco"));
        System.out.println(petMap);

        Pet dog = petMap.get("My Dog");
        System.out.println(dog);
        System.out.println(petMap.containsKey("My Dog"));
        System.out.println(petMap.containsValue(dog));

        Dog dog2 = new Dog("Ginger");
        System.out.println(petMap.containsValue(dog2));


    }
}
