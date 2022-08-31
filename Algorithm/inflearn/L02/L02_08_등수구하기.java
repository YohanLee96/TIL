package inflearn.L02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/08/22.
 * N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
 * 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
 * 즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
 * Input
 * 첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.
 * Output
 * 입력된 순서대로 등수를 출력한다.
 **/
public class L02_08_등수구하기 {

    public int[] solution(int n, int[] arr) {
        int[] result = new int[n];
        int maxRank = 0;
        for (int i = 0; i < arr.length; i++) {
            int lRank = arr[i];
            int cnt = 1;
            for (int rRank : arr) {
                if (lRank < rRank) {
                    cnt += 1;
                }
            }
            result[i] = cnt;
        }
        return result;
    }

    public static void main(String[] args) {
        L02_08_등수구하기 program = new L02_08_등수구하기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        for (int num : program.solution(n, arr)) {
            System.out.print(num + " ");
        }
    }

}

