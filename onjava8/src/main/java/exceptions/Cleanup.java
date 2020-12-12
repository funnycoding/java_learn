package exceptions;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/27 2:45 下午
 */
// exceptions/Cleanup.java
public class Cleanup {
    public static void main(String[] args) {
        try {
            InputFile in = new InputFile("Cleanup.java");
            try {
                String s;
                int i = 1;
                while ((s = in.getLine()) != null) {
                    //在这里进行逐行处理
                    System.out.println(s);
                }

            } catch (Exception e) {
                System.out.println("Caught Exception in main");
                e.printStackTrace(System.out);
            } finally {
                in.dispose();
            }
        } catch (Exception e) {
            System.out.println("Inputfile 构造失败");
        }
    }
}
