package generics;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/14 10:01 上午
 */

// generics/GenericArray2.java
// 泛型数组的元素 put 和 get 都正常，但是将数组强转为泛型类型的数组仍然会抛出类型转换异常
public class GenericArray2<T> {
    private Object[] array;

    public GenericArray2(int sz) {
        array = new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = index;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index]; // Unchecked cast
    }

    @SuppressWarnings("unchecked")
    public T[] rep() {
        return (T[]) array; // 将当前数组用泛型参数进行类型强转
    }


    public static void main(String[] args) {
        GenericArray2<Integer> gai = new GenericArray2<>(10);
        for (int i = 0; i < 10; i++) {
            gai.put(i, i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(gai.get(i) + " ");
        }
        System.out.println();

        try {
            Integer[] rep = gai.rep(); // 仍然会抛出类型转换异常
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
