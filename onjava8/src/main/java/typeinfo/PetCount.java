package typeinfo;

import java.util.HashMap;
import typeinfo.pets.Cat;
import typeinfo.pets.Cymric;
import typeinfo.pets.Dog;
import typeinfo.pets.EgyptianMau;
import typeinfo.pets.ForNameCreator;
import typeinfo.pets.Hamster;
import typeinfo.pets.Manx;
import typeinfo.pets.Mouse;
import typeinfo.pets.Mutt;
import typeinfo.pets.Pet;
import typeinfo.pets.PetCreator;
import typeinfo.pets.Pug;
import typeinfo.pets.Rat;
import typeinfo.pets.Rodent;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/29 11:56 上午
 */

public class PetCount {

    static HashMap<String,Integer> counter = new HashMap<>();
    public void count( HashMap<String,Integer> counter,String type) {
        Integer quantity = counter.get(type);
        if (quantity == null) {
            counter.put(type, 1);
        } else {
            counter.put(type, quantity + 1);
        }
    }

    // 为什么这里要用静态内部类继承 HashMap 而不是直接使用组合来用？
    static class Counter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }
        }
    }

    public static void countPets(PetCreator creator) {


        Counter counter = new Counter();

        PetCount petCount = new PetCount();

        for (Pet pet : typeinfo.pets.Pets.array(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            if (pet instanceof Pet) {
                counter.count("Pet");
                petCount.count(PetCount.counter,"Pet");
            }
            if (pet instanceof Dog) {
                counter.count("Dog");
                petCount.count(PetCount.counter,"Dog");
            }
            if (pet instanceof Mutt) {
                counter.count("Mutt");
                petCount.count(PetCount.counter,"Mutt");
            }
            if (pet instanceof Pug) {
                counter.count("Pug");
                petCount.count(PetCount.counter,"Pug");
            }
            if (pet instanceof Cat) {
                counter.count("Cat");
                petCount.count(PetCount.counter,"Cat");
            }
            if (pet instanceof EgyptianMau) {
                counter.count("EgyptianMau");
                petCount.count(PetCount.counter,"EgyptianMau");
            }
            if (pet instanceof Manx) {
                counter.count("Manx");
                petCount.count(PetCount.counter,"Manx");
            }
            if (pet instanceof Cymric) {
                counter.count("Cymric");
                petCount.count(PetCount.counter,"Cymric");
            }
            if (pet instanceof Rodent) {
                counter.count("Rodent");
                petCount.count(PetCount.counter,"Rodent");
            }
            if (pet instanceof Rat) {
                counter.count("Rat");
                petCount.count(PetCount.counter,"Rat");
            }
            if (pet instanceof Mouse) {
                counter.count("Mouse");
                petCount.count(PetCount.counter,"Mouse");
            }
            if (pet instanceof Hamster) {
                counter.count("Hamster");
                petCount.count(PetCount.counter,"Hamster");
            }

        }
        System.out.println();
        System.out.println(counter);
        System.out.println("-----------");
        System.out.println(PetCount.counter);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
}
