package inflearn.L03;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/09/18.
 * N개의 수로 이루어진 수열이 주어집니다.
 * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
 * 만약 N=8, M=6이고 수열이 다음과 같다면
 * 1 2 1 3 1 1 1 2
 * 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
 * Input
 * 첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
 * 수열의 원소값은 1,000을 넘지 않는 자연수이다.
 * Output
 * 첫째 줄에 경우의 수를 출력한다.
 **/
public class L03_04_연속_부분수열 {


    public int solution(int n, int m, int[] arr) {
        int result = 0;
        int max = 0;
        int pi = 0;
        for (int i = 0; i < n; i++) {
            max += arr[i];
            while (m < max) {
                max -= arr[pi++];
            }
            if(max == m) result++;
        }
        return result;
    }



    public static void main(String[] args) {
        L03_04_연속_부분수열 program = new L03_04_연속_부분수열();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(program.solution(n, m, arr));
    }
}
