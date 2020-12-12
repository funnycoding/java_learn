package interfaces;//package com.aibook.onjava.ten;
//
///**
// * @author XuYanXin
// * @program aibook-parent
// * @description
// * @date 2020/2/11 9:00 下午
// */
//
//interface I1 {
//    void f();
//}
//
//interface I2 {
//    int f(int i);
//}
//
//interface I3 {
//    int f();
//}
//
//class C {
//    public int f() {
//        return 1;
//    }
//}
//
//class C2 implements I1, I2 {
//
//    @Override
//    public void f() {
//
//    }
//
//    @Override
//    public int f(int i) {
//        return 1; // 重载，但是我觉得这里不对，这里只是实现了 I2的接口，跟重载有啥关系
//    }
//}
//
///**
// * C有一个 无参的 f() H桉树， I2 有一个 入参为 int的 f(int) 函数，这里实现接口的抽象方法
// */
//class C3 extends C implements I2 {
//    @Override
//    public int f(int i) {
//        return 1; // 重载
//    }
//}
//
///**
// * C 和 I3 的f()函数完全一致
// */
//class C4 extends C implements I3 {
//    @Override
//    public int f() {
//        return 1;
//    }￿￿
//}
//
///**
// * 这里就出问题了 C和I1 的 f函数都是 无参函数，方法签名一致，但是返回值不同 一个是 void 一个是 int 导致编译器提示报错
// */
///*
//class C5 extends C implements I1 {
//
//}
//*/
//
//public class InterfaceCollision {
//
//}
