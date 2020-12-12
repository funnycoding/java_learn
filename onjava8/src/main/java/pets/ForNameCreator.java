// typeinfo/pets/ForNameCreator.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<>();
    // 一个 pets 的 类名数组
    private static String[] typeNames = {
            "typeinfo.pets.Mutt",
            "typeinfo.pets.Pug",
            "typeinfo.pets.EgyptianMau",
            "typeinfo.pets.Manx",
            "typeinfo.pets.Cymric",
            "typeinfo.pets.Rat",
            "typeinfo.pets.Mouse",
            "typeinfo.pets.Hamster"
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
          for (String name : typeNames) {
            types.add((Class<? extends Pet>) Class.forName(name));
          }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
