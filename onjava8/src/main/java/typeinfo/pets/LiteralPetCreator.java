
// {java typeinfo.pets.LiteralPetCreator}
package typeinfo.pets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// typeinfo/pets/LiteralPetCreator.java
// 使用类字面量
public class LiteralPetCreator extends PetCreator {

    public static final List<Class<? extends Pet>> ALL_TYPES =
            Collections.unmodifiableList(Arrays.asList(
                    Pet.class, Dog.class, Cat.class, Rodent.class,
                    Mutt.class, Pug.class, EgyptianMau.class,
                    Manx.class, Cymric.class, Rat.class,
                    Mouse.class, Hamster.class
            ));

    // 这里是将所有类型的子集 从 Mutt.class 开始到结尾作为一个随机创建的集合返回
    private static final List<Class<? extends Pet>> TYPES = ALL_TYPES
            .subList(ALL_TYPES.indexOf(Mutt.class), ALL_TYPES.size());

    // try 代码块不再需要
    @Override
    public List<Class<? extends Pet>> types() {
      //System.out.println("LiteralPetCreator 的 types() 被调用了");
        return TYPES;
    }

    public static void main(String[] args) {
        System.out.println(TYPES);
    }
}
