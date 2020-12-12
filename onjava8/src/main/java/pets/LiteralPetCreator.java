// typeinfo/pets/LiteralPetCreator.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Using class literals
// {java typeinfo.pets.LiteralPetCreator}
package pets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LiteralPetCreator extends PetCreator {
    // No try block needed.
    @SuppressWarnings("unchecked")
    public static final List<Class<? extends Pet>> ALL_TYPES =
            Collections.unmodifiableList(Arrays.asList(
                    Pet.class, Dog.class, Cat.class, Rodent.class,
                    Mutt.class, Pug.class, EgyptianMau.class,
                    Manx.class, Cymric.class, Rat.class,
                    Mouse.class, Hamster.class));
    // 这里其实并不是随机创建的，而是从 Mutt 之后截取一个子集
    private static final List<Class<? extends Pet>> TYPES =
            ALL_TYPES.subList(ALL_TYPES.indexOf(Mutt.class),
                    ALL_TYPES.size());

  private static final List<Class<? extends Pet>> TYPES2 =
          ALL_TYPES.subList(new Random().nextInt(12),
                  ALL_TYPES.size());


  @Override
    public List<Class<? extends Pet>> types() {
        return TYPES;
    }

    public static void main(String[] args) {
        System.out.println(TYPES);
    }
}
/* Output:
[class typeinfo.pets.Mutt, class typeinfo.pets.Pug,
class typeinfo.pets.EgyptianMau, class
typeinfo.pets.Manx, class typeinfo.pets.Cymric, class
typeinfo.pets.Rat, class typeinfo.pets.Mouse, class
typeinfo.pets.Hamster]
*/
