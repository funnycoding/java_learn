package generics;

import java.util.stream.Stream;
import onjava.BasicSupplier;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/12 11:41 上午
 */

// generics/BasicSupplierDemo.java
public class BasicSupplierDemo  {
    public static void main(String[] args) {
        Stream.generate(BasicSupplier.create(CountedObject.class))
        //Stream.generate(new BasicSupplier<>(CountedObject.class))
                .limit(5)
                .forEach(System.out::println);
    }
}
