package inflearn.L07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yohan lee
 * Created on 2023/02/06.
 * 아래 그림과 같은 이진트리 레벨탐색을 연습하세요
 **/
public class L07_07_이진트리_레벨탐색_BFS {

    static Node root;

    public static void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0; // root Node는 1
        while (!Q.isEmpty()) { //비어있을때까지 루프
            int len = Q.size();
            System.out.print(L + " -> ");
            for(int i=0; i<len; i++) {
                Node current = Q.poll();
                System.out.print(current.data + " ");
                if(current.lt != null) {
                    Q.offer(current.lt);
                }
                if(current.rt != null) {
                    Q.offer(current.rt);
                }
            }
            L++;
            System.out.println();
        }

    }
    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        root.lt.lt.lt = new Node(8);
        root.lt.lt.rt = new Node(9);
        root.lt.rt.lt = new Node(10);
        root.lt.rt.rt = new Node(11);
        root.rt.lt.lt = new Node(12);
        root.rt.lt.rt = new Node(13);
        root.rt.rt.lt = new Node(14);
        root.rt.rt.rt = new Node(15);
        BFS(root);
    }


    static class Node {
         int data;
         Node lt;
         Node rt;

        public Node(int data) {
            this.data = data;
            this.lt = null;
            this.rt = null;
        }
    }
}
