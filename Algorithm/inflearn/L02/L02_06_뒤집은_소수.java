package inflearn.L02;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/08/16.
 * N개의 자연수가 입력되면 각 자연수를 뒤집은 후
 * 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
 * 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다.
 * 단 910를 뒤집으면 19로 숫자화 해야 한다.
 * 첫 자리부터의 연속된 0은 무시한다.
 **/
public class L02_06_뒤집은_소수 {


    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        for (int i : arr) {
            int tmp = i;
            int res = 0;
            while(tmp > 0) {
                int t = tmp %10;
                res = res * 10 +t;
                tmp = tmp/10;
            }
            if(prime(res)) {
                System.out.print(res + " ");
            }
        }
        return answer;
    }

    private boolean prime(int n) {
        if(n <2) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if(n%i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        L02_06_뒤집은_소수 program = new L02_06_뒤집은_소수();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        program.solution(n, arr);
    }
}
