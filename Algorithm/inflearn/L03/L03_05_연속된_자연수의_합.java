package inflearn.L03;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/09/20.
 * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
 * 만약 N=15이면
 * 7+8=15
 * 4+5+6=15
 * 1+2+3+4+5=15
 * Input
 * 첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.
 * Output
 * 첫 줄에 총 경우수를 출력합니다.
 **/
public class L03_05_연속된_자연수의_합 {


    public int solution(int n) {
        int result = 0;
        int max = n/2+1;
        int[] arr = new int[max];
        //모든 숫자를 담은 배열만들기
        for (int i = 0; i < max; i++) arr[i] = i+1;
        int sum = 0;
        int pi = 0;
        for (int i = 0; i < max; i++) {
            sum += arr[i];
            while (n < sum){
                sum -= arr[pi++];
            }
            if(sum == n) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        L03_05_연속된_자연수의_합 program = new L03_05_연속된_자연수의_합();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        System.out.println(program.solution(num));
    }
}
