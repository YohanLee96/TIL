package inflearn.L03;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/09/20.
 * 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
 * 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 * 여러분이 만들 수 있는 1이 연속된 연속부분수열의 길이는 8입니다.
 *
 * Input
 * 첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
 * 두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
 *
 * Output
 * 첫 줄에 최대 길이를 출력하세요.
 **/
public class L03_07_최대_길이_연속부분수열 {

    public int solution(int n, int k, int[] arr) {
        int max = 0;
        int lt = 0;
        int cnt = 0;
        for (int rt = 0; rt < n; rt++) {
            if(arr[rt] == 0) {
                cnt++; //0횟수 누적
            }
            while (k < cnt) {
                if(arr[lt] == 0) cnt--;
                lt++;
            }
            int sum = rt - lt+1; //길이 계산
            if(max < sum) {
                max = sum;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        L03_07_최대_길이_연속부분수열 program = new L03_07_최대_길이_연속부분수열();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(program.solution(n, k, arr));
    }
}
