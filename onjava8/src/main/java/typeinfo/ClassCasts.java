package typeinfo;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/28 8:41 下午
 */
// typeinfo/ClassCasts.java
class Building {
}

class House extends Building {
}

public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();

        Class<House> houseType = House.class;

        // 下面两种方式进行类型转换效果相同
        House h = houseType.cast(b);
        h = (House) b;
    }
}
