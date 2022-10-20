package inflearn.L04;

import java.util.Collections;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Yohan lee Created on 2022/10/20.
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
