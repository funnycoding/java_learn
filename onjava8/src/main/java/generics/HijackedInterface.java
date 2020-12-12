package generics;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/3/16 2:52 下午
 */
/*
// generics/HijackedInterface.java
// {WillNotCompile}
// 这里编译器会告诉你 Comparable 不能持有多种不同给的参数
class Cat extends ComparablePet implements Comparable<Cat> {
    // error: Comparable cannot be inherited with
    // different arguments: <Cat> and <ComparablePet>
    // class Cat
    // ^
    // 1 error
    public int compareTo(Cat arg) {
        return 0;
    }
}

public class HijackedInterface {
}
*/
