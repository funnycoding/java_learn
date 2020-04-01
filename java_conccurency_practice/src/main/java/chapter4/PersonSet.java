package chapter4;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/1 4:13 下午
 */

import java.util.HashSet;
import java.util.Set;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * PersonSet
 * <p/>
 * Using confinement to ensure thread safety
 * 使用线程封闭来确保线程的安全性
 *
 * @author Brian Goetz and Tim Peierls
 */
// 使用线程封闭来确保线程的安全性 本类并不是一个线程安全的类，但是通过线程封闭与内置锁保证了在多线程环境下使用本类的线程安全性
// PersonSet.java
@ThreadSafe
public class PersonSet {
    @GuardedBy("this")
    private final Set<Person> mySet = new HashSet<>();

    public synchronized void addPerson(Person person) {
        mySet.add(person);
    }

    public synchronized boolean containPerson(Person p) {
        return mySet.contains(p);
    }


    interface Person {
    }
}
