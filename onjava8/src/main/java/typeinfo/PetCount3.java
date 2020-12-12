package typeinfo;


import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import typeinfo.pets.LiteralPetCreator;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;
import utils.Pair;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/29 2:17 下午
 */
// PetCount3.java
public class PetCount3 {
    static class Counter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        Counter() {
            super(LiteralPetCreator.ALL_TYPES.stream()
                    .map(lpc -> Pair.make(lpc, 0))
                    .collect(Collectors.toMap(Pair::key, Pair::value)));
        }

        public void count(Pet pet) {
            // Class.isInstance() 替代 instanceof
            entrySet().stream()
                    .filter(pair -> pair.getKey().isInstance(pet)) // 判断类型是否相同
                    .forEach(pair -> put(pair.getKey(), pair.getValue() + 1));
        }

        @Override
        public String toString() {
            String result = entrySet().stream()
                    .map(pair -> String.format("%s=%s", pair.getKey().getSimpleName(),
                            pair.getValue()))
                    .collect(Collectors.joining(", "));
            return "{ " + result + " }";
        }

        public static void main(String[] args) {
            Counter petCount = new Counter();
            Pets.stream()
                    .limit(20)
                    .peek(petCount::count)
                    .forEach(p -> System.out.print(p.getClass().getSimpleName() + " "));
            System.out.println();
            System.out.println("------------");
            System.out.println( petCount);
        }
    }
}
