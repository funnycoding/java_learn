package onjava;

import apple.laf.JRSUIConstants.Widget;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/3/15 10:03 下午
 */
// generics/ClassCasting.java
public class ClassCasting {
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
        // 下面的无法被编译 这里使用类型转换不能带有泛型
        //List<Widget> lw1 = List<>.class.cast(in.readObject());
        List<Widget> lw2 = List.class.cast(in.readObject());
        //List<Widget> lw3 = List<Widget>.class.cast(in.readObject());
        List<Widget> lw3 = (List<Widget>)List.class.cast(in.readObject());
    }
}
