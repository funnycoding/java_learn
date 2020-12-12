package onjava;

import java.util.List;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/3/15 10:27 下午
 */
// generics/UseList.java
public class UseList<W,T> {
    // 擦除导致这两个方法的签名重合
    //void f(List<T> v) {}
    void f(List<W> v) {}
}
