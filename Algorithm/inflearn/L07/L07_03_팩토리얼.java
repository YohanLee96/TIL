package inflearn.L07;

/**
 * Created by Yohan lee
 * Created on 2023/01/30.
 * 자연수 N이 입력되면 N!를 구하는 프로그램을 작성하시오.
 *
 * 첫번째 줄에 출력.
 **/
public class L07_03_팩토리얼 {

    public static int DFS(int n) {
        if(n == 1) {
            return 1;
        }
        return n * DFS(n -1);

    }

    public static void main(String[] args) {
        System.out.println(DFS(3));
    }
}
