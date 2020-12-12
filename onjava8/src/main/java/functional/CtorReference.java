package functional;

import java.util.StringJoiner;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/17 7:20 下午
 */

// 三个接口都是构造 Dog 实例的方法 对应 dog 的三个构造函数、
// functional/CtorReference.java
interface MakeNoArgs {
    Dog make();
}

interface Make1Args {
    Dog make(String name);
}

interface Make2Args {
    Dog make(String nm, int age);
}


//CtorReference.java
// 三个构造函数对应上面的三个接口
class Dog {
    String name;
    int age = -1;


    public Dog() {
        name = "default Dog Name";
    }

    public Dog(String name) {
        this.name = name;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Dog.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .toString();
    }
}


public class CtorReference {
    public static void main(String[] args) {
        // 分别将三个构造器的方法引用赋给了3个对象的接口
        // 这里我还观察到了一个现象，就是构造函数的赋值形式和静态方法是一样的
        // 书里一直有个观念 构造函数是隐式静态方法，我之前一直存怀疑态度，但是在这里
        // 至少语法上是一致的
        MakeNoArgs mna = Dog::new; //[1] 将无参构造函数绑定给 MakeNoArgs 接口的 make() 方法
        Make1Args m1a = Dog::new; //[2] 将1个参数的构造函数绑定给 MakeNoArgs 接口的 Dog make(String name) 方法
        Make2Args m2a = Dog::new; //[2] 将2个参数的构造函数绑定给 MakeNoArgs 接口的  Dog make(String nm, int age) 方法

        Dog dn = mna.make();
        Dog d1 = m1a.make("Comet");
        Dog d2 = m2a.make("Ralph", 4);
        System.out.println("无参dh: " + dn);
        System.out.println("1个参数的d1: " + d1);
        System.out.println("2个参数的d2: " + d2);
    }
}
