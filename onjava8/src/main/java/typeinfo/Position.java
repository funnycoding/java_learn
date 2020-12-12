package typeinfo;

import java.util.Optional;
import java.util.StringJoiner;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/4 11:00 下午
 */

//typeinfo/Position.java
class EmptyTitleException extends RuntimeException {
}

public class Position {
    private String title;
    private Person person;

    public Position(String title, Person employee) {
        setTitle(title);
        setPerson(employee);
    }
    // 设置一个空的职位
    Position(String jobTitle) {
        this(jobTitle, null);
    }

    public String getTitle() {
        return title;
    }


    // 如果设置Title的时候传入的值为null则抛出对应异常
    public void setTitle(String newTitle) {
        title = Optional.ofNullable(newTitle).orElseThrow(EmptyTitleException::new);
    }

    public Person getPerson() {
        return person;
    }

    // 如果传入的员工为null则在方法中重新构造一个Person对象
    public  void setPerson(Person newPerson) {
        person = Optional.ofNullable(newPerson).orElse(new Person());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Position.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .add("person=" + person)
                .toString();
    }

    public static void main(String[] args) {
        System.out.println(new Position("CEO"));
        System.out.println(new Position("Programmer",new Person("Ahri","Ricky")));
        try {
            // 抛出 EmptyTitleException
            new Position(null);
        } catch (Exception e) {
            System.out.println("Caught: " + e);
        }
    }
}
