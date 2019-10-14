package cn.alogi;

import java.awt.geom.Line2D;
import java.util.LinkedList;
import java.util.List;

public class 层序遍历二叉树 {
    public static void print(Node root){
        if(root == null){
            return;
        }
        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.add(root);
        while(!linkedList.isEmpty()){
            Node temp = linkedList.poll();
            System.out.println(temp.data);
            if(temp.left != null){
                linkedList.add(temp.left);
            }
            if(temp.right != null){
                linkedList.add(temp.right);
            }
        }
    }

    public static List<List<Integer>> printList(Node root){
        if(root == null){
            return null;
        }
        LinkedList<List<Integer>> listAll = new LinkedList<>();
        LinkedList<Node> listQueen = new LinkedList<>();
        listQueen.add(root);
        while(!listQueen.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            listAll.add(list);
            int j = listQueen.size();
            for(int i = 0; i < j; i++){
                Node temp = listQueen.poll();
                list.add(temp.data);
                if(temp.left != null){
                    listQueen.add(temp.left);
                }
                if(temp.right != null){
                    listQueen.add(temp.right);
                }
            }
        }
        return listAll;
    }
    public static void main(String[] args){
        int j = 5;
        for(int i = 0; i < j; i++){
            j = i + 2;
            System.out.println(i);
        }
    }
}
class Node{
    public int data;
    public Node left;
    public Node right;
}
