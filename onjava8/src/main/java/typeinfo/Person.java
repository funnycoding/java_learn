package typeinfo;

import java.util.Optional;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/4 10:45 下午
 */
// typeinfo/Person.java
public class Person {
    public final Optional<String> first;
    public final Optional<String> last;
    public final Optional<String> address;
    // etc.
    public final Boolean empty;

    Person(String first, String last, String address) {
        // 无论入参对象是否为null，都会有一个 Optional 赋值给对应的字段。
        this.first = Optional.ofNullable(first);
        this.last = Optional.ofNullable(last);
        this.address = Optional.ofNullable(address);
        // 三个字段都为空，则 empty 为 true
        empty = !this.first.isPresent() && !this.last.isPresent() && !this.address.isPresent();
    }

    Person(String first, String last) {
        this(first, last, null);
    }

    Person(String last) {
        this(null, last, null);
    }

    Person() {
        this(null, null, null);
    }

    @Override
    public String toString() {
        // 如果三个字段都不存在，返回  "<Empty>"
        if (empty) {
            return "<Empty>";
        }   // 如果有值就打印，没有值的话取默认值 空字符串
        return (first.orElse("") + " "
                + last.orElse("") + " "
                + address.orElse("")).trim();
    }

    public static void main(String[] args) {
        System.out.println(new Person());
        System.out.println(new Person("Smith"));
        System.out.println(new Person("Bob", "Smith"));
        System.out.println(new Person("Bob", "Smith",
                "11 Degree Lane, Frostbite Falls, MN"));
    }

}
