package inflearn.L02;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/08/31.
 **/
public class L02_09_격자판_최대합 {

    public int solution(int[][] arr) {
        int result = 0;
        int max = 0;
        int lDigSum = 0; //왼쪽 대각선
        int rDigSum = 0; //오른쪽 대각선
        for (int i = 0; i < arr.length; i++) {
            int rSum = 0; //가로
            int cSum = 0; //세로
            for (int j = 0; j < arr.length; j++) {
                rSum += arr[i][j]; //가로 탐색
                cSum += arr[j][i]; //세로 탐색
                if(i ==j) {
                    lDigSum += arr[i][j]; //왼쪽 대각선 탐색
                } else if(i+j == arr.length -1) {
                    rDigSum += arr[i][j]; //오른쪽 대각선 탐색
                }
            }
            //탐색 끝
            if(max < Math.max(rSum, cSum)) {
                max = Math.max(rSum, cSum);
            }
        }

        result = Math.max(max, Math.max(lDigSum, rDigSum));

        return result;
    }


    public static void main(String[] args) {
        L02_09_격자판_최대합 program = new L02_09_격자판_최대합();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.print(program.solution(arr));
    }
}
