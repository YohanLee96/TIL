package inflearn.L06;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/11/20. N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요. 정렬하는 방법은 버블정렬입니다.
 * <p>
 * Input 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다. 두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다. Output 오름차순으로 정렬된 수열을 출력합니다.
 **/
public class L06_02_버블정렬 {

    public int[] solution(int n, int[] arr) {
        return arr;
    }

    public static void main(String[] args) {
        L06_02_버블정렬 program = new L06_02_버블정렬();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        for (int i : program.solution(n, arr)) {
            System.out.print(i + " ");
        }
    }
}
