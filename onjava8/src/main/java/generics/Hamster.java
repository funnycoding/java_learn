package generics;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/3/16 2:54 下午
 */


// generics/RestrictedComparablePets.java
// 这里这个类名不知道作者想表达啥。。。 跟 Hamster 对不上
public class Hamster extends ComparablePet implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet o) {
        return super.compareTo(o);
    }
}

// Or just: 不指明泛型参数
class Gecko extends ComparablePet {
    public int compareTo(ComparablePet arg) {
        return 0;
    }
}