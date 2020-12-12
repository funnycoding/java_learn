package test;

import java.util.ArrayList;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/5/31 4:50 下午
 */

public class MyBinaryTree <T>{
    private ArrayList<Integer> root;
    private int size;

    public MyBinaryTree( T root){
        //MyBinaryTree<String> stringTree = new MyBinaryTree<>("root");
        //MyBinaryTree<Integer> intTree = new MyBinaryTree<>(1);

    }

    public void addTreeNodes(String directions, T[] values){

    }

    public String levelTraverse(){
        return "0";
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Integer> getRoot() {
        return root;
    }

    public void setRoot(ArrayList<Integer> root) {
        this.root = root;
    }


    public static void main(String[] args) {
        MyBinaryTree<String> root = new MyBinaryTree<>("root");
    }
}
