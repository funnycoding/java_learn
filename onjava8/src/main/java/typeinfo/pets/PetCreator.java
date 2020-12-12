package typeinfo.pets;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/29 12:34 上午
 */

public abstract class PetCreator implements Supplier<Pet> {
    private Random random = new Random(47);

    // 生成不同类型的Pet的List的方法
    public abstract List<Class<? extends Pet>> types();

    @Override
    public Pet get() { // 随机创建一个Pet
        int n = random.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
