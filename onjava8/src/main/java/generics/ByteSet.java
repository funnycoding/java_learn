package generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/3/15 7:58 下午
 */
// generics/ByteSet.java
public class ByteSet {
    Byte[] possibles = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    Set<Byte> mySet = new HashSet<>(Arrays.asList(possibles));
    // But you can't do this:
    //Set<Byte> mySet2 = new HashSet<>(Arrays.<Byte>asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

}