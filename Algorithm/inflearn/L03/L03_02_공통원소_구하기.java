package inflearn.L03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/09/11.
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
 * Input
 * 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
 * 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
 * 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * 각 집합의 원소는 1,000,000,000이하의 자연수입니다.
 * Output
 * 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
 **/
public class L03_02_공통원소_구하기 {

    public List<Integer> solution(int n, int[] arr1, int m, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if(arr1[p1] == arr2[p2]) {
                result.add(arr1[p1++]);
                p2++;
            } else if(arr1[p1] < arr2[p2]) p1++;
            else p2++;
        }



        return result;
    }

    public static void main(String[] args) {
        L03_02_공통원소_구하기 program = new L03_02_공통원소_구하기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = kb.nextInt();
        }
        int m = kb.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = kb.nextInt();
        }

        for (int num : program.solution(n, arr1, m, arr2)) {
            System.out.print(num + " ");
        }
    }
}
