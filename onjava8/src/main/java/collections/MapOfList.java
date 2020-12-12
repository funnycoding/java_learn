package collections;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pets.Cat;
import pets.Cymric;
import pets.Dog;
import pets.Mutt;
import pets.Person;
import pets.Pet;
import pets.Pug;
import pets.Rat;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/16 4:56 下午
 */

public class MapOfList {
    public static final Map<Person, List<? extends Pet>> petPeople = new HashMap<>();

    // 静态代码块添加了多个拥有多只宠物的人
    static {
        petPeople.put(new Person("Dawn"), Arrays.asList(new Cymric("Molly"), new Mutt("Spot")));
        petPeople.put(new Person("Kate"),
                Arrays.asList(new Cat("Shackleton"),
                        new Cat("Elsie May"), new Dog("Margrett")));
        petPeople.put(new Person("Marilyn"),
                Arrays.asList(
                        new Pug("Louie aka Louis Snorkelstein Dupree"),
                        new Cat("Stanford"),
                        new Cat("Pinkola")));
        petPeople.put(new Person("Luke"),
                Arrays.asList(
                        new Rat("Fuzzy"), new Rat("Fizzy")));
        petPeople.put(new Person("Isaac"),
                Arrays.asList(new Rat("Freckly")));
    }

    public static void main(String[] args) {
        // 获取petPle 中的 Key 的集合
        System.out.println("People: " + petPeople.keySet());
        System.out.println("Pets: " + petPeople.values());
        for (Person p : petPeople.keySet()) {
            System.out.println(p + " has");
            for (Pet pet : petPeople.get(p)) {
                System.out.println("    " + pet);
            }
        }
    }

}
