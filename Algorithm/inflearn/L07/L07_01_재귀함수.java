package inflearn.L07;

/**
 * Created by Yohan lee
 * Created on 2023/01/30.
 * 자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하시오.
 **/
public class L07_01_재귀함수 {

    /**
     * 스택에 스택프레임이 3부터 1까지 쌓인다.
     * 스택프레임 : 지역변수, 매개변수, 복귀주소
     * 3의 복귀주소 -> 2
     * 2의 복귀주소 -> 1
     * 1의 복귀주소 -> 0
     * 스택 구조이기 때문에 0의 스택프레임부터 동작.
     */
    public void DFS(int n) {
        if (n == 0) return;
        else {
            DFS(n -1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        L07_01_재귀함수 program = new L07_01_재귀함수();
        program.DFS(3);
    }
}
