package inflearn.L07;

/**
 * Created by Yohan lee
 * Created on 2023/02/01.
 * 이진트리의 전위순회 후외순회를 연습해보세요
 **/
public class L07_05_이진트리_순회 {


    //전위순회 DFS
    public static void preOrderDFS(Node root) {
        if(root == null) return;
        print(root.data);
        preOrderDFS(root.lt);
        preOrderDFS(root.rt);
    }

    //후위순회 DFS
    public static void postOrderDFS(Node root) {
        if(root == null) return;
        postOrderDFS(root.lt);
        postOrderDFS(root.rt);
        print(root.data);
    }

    //중위순회 DFS
    public static void inOrderDFS(Node root) {
        if(root == null) return;
        inOrderDFS(root.lt);
        print(root.data);
        inOrderDFS(root.rt);
    }

    public static void print(int val) {
        System.out.print(val + " ");
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        preOrderDFS(root); //전위
        System.out.println();
        postOrderDFS(root); //후위
        System.out.println();
        inOrderDFS(root); //중위
    }


    static class Node {
        int data;
        Node lt;
        Node rt;

        public Node(int data) {
            this.data = data;
            lt = null;
            rt = null;
        }


    }
}

