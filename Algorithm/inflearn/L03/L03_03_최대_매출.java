package inflearn.L03;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/09/11.
 * 현수의 아빠는 제과점을 운영합니다.
 * 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
 * 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
 * 12 1511 20 2510 20 19 13 15
 * 연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
 * 여러분이 현수를 도와주세요.
 *
 * Input
 * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 * Output
 * 첫 줄에 최대 매출액을 출력합니다.
 **/
public class L03_03_최대_매출 {

    public int solution(int k, int n, int[] arr) {
        int pi = 0;
        for (int i = 0; i < k; i++) pi += arr[i];
        int result =  pi;
        for (int i = k; i < n; i++) {
            //현재 배열 첫인덱스값 제거 후, 마지막 인덱스값 추가.
            int next = pi - arr[i-k] + arr[i];
            if(result < next) result = next; //추가한 값이 더클경우, 결과값에 대입.
            pi = next; //다음 연산을 위해 현재 연산한 값 저장.

        }
        return result;
    }

    public static void main(String[] args) {
        L03_03_최대_매출 program = new L03_03_최대_매출();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(program.solution(k, n, arr));
    }
}
