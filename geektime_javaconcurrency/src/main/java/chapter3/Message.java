//package chaoter3;
//
///**
// * @author XuYanXin
// * @program javaconcurrency_learn
// * @description
// * @date 2020/8/18 8:40 下午
// */
//
//public class Message {
//    String id;
//    String content;
//
//    // 发送消息的方法
//    void send(Message msg) {
//        // 具体逻辑
//    }
//
//    // MQ 消息返回后调用该方法，但是该方法的执行线程与发送消息的线程不一致
//    void onMeesage(Message msg) {
//        // 省略相关业务代码
//    }
//
//    // 处理浏览器发送的请求
//    Respond handleWebReq() {
//        // 创建一个消息
//        Message msg = new Message("1", "{...}");
//
//        // 发送消息
//        send(msg);
//
//        // 如何等待 MQ 返回的消息
//        String result = ...;
//    }
//}
