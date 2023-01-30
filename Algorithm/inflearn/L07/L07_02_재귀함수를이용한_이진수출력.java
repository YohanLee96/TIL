package inflearn.L07;

/**
 * Created by Yohan lee
 * Created on 2023/01/30.
 * 10진수 n이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하시오.
 * 단 재귀함수를 이용하여 출력해야 합니다.
 *
 * 첫번째 줄에 2진수를 출력하세요
 **/
public class L07_02_재귀함수를이용한_이진수출력 {

    public void DFS(int n) {
        if(n == 0) {
            return;
        }
        DFS(n /2);
        System.out.print(n%2);
    }

    public static void main(String[] args) {
        L07_02_재귀함수를이용한_이진수출력 program = new L07_02_재귀함수를이용한_이진수출력();
        program.DFS(34);
    }
}
