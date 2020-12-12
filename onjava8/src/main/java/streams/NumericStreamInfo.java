package streams;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/22 10:30 下午
 */
public class NumericStreamInfo {
    public static void main(String[] args) {
        System.out.println(RandInts.rands().average().getAsDouble());
        System.out.println(RandInts.rands().max().getAsInt());
        System.out.println(RandInts.rands().min().getAsInt());
        System.out.println(RandInts.rands().sum());
        System.out.println(RandInts.rands().summaryStatistics());
    }
}
