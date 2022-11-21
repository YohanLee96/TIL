package inflearn.L03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/09/07.
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
 *
 * Input
 * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
 * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
 * 
 * Output
 * 오름차순으로 정렬된 배열을 출력합니다.
 **/
public class L03_01_두_배열_합치기 {

    public List<Integer> answerSolution(int n, int[] arr1, int m, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 <n && p2 < m) {
            if(arr1[p1] < arr2[p2]) result.add(arr1[p1++]);
            else result.add(arr2[p2++]);
        }
        while (p1 <n) result.add(arr1[p1++]);
        while (p2 <m) result.add(arr2[p2++]);

        return result;
    }


    public int[] solution(int n, int[] arr1, int m, int[] arr2) {
        int[] result = new int[n+m];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < n+m; i++) {
            if(i1 == n) {
                result[i] = arr2[i2++];
                continue;
            } else if(i2 == m) {
                result[i] = arr1[i1++];
                continue;
            }
            if(arr1[i1] < arr2[i2]) {
                result[i] = arr1[i1++];
            } else if(arr1[i1] > arr2[i2]) {
                result[i] = arr2[i2++];
            } else {
                result[i] = arr1[i1++];
                result[++i] = arr2[i2++];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        L03_01_두_배열_합치기 program = new L03_01_두_배열_합치기();
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
