package inflearn.L04;

import java.util.Collections;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Yohan lee Created on 2022/10/20.
 * 현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
 * 현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
 * 기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
 * 만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.
 * Input
 * 첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.
 * Output
 * 첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.
 **/
public class L04_05_K번째_큰수 {

    public int solution(int n, int k, int[] arr) {
        if(n < k) { //크면 루프돌 필요도 없음.
            return  -1;
        }
        SortedSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int l = j+1; l < n; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int cnt = 0;
        for (Integer num : set) {
            cnt++;
            if(cnt == k) return num;
        }

        return -1;
    }

    public static void main(String[] args) {
        L04_05_K번째_큰수 program = new L04_05_K번째_큰수();
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
