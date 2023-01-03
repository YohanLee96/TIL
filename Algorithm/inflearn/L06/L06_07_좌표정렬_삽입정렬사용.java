package inflearn.L06;

import java.util.Scanner;

/**
 * Created by Yohan lee
 * Created on 2023/01/01.
 *
 * N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
 * 정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.
 *
 * Input
 * 첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
 * 두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.
 * Output
 * N개의 좌표를 정렬하여 출력하세요.
 **/
public class L06_07_좌표정렬_삽입정렬사용 {

    public int[][] solution(int n, int[][] arr) {
        for (int i = 1; i < n; i++) {
            int[] tmp = arr[i];
            int j;
            for (j = i-1; 0 <= j; j--) {
                if(tmp[0] == arr[j][0]) { //x좌표가 같을 경우,
                    if(tmp[1] < arr[j][1]) {
                        arr[j+1] = arr[j];
                    } else {
                        break;
                    }
                } else if(tmp[0] < arr[j][0]) { //x좌표가 더 높을 경우,
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }

            arr[j+1] = tmp;

        }
        return arr;
    }

    public static void main(String[] args) {
        L06_07_좌표정렬_삽입정렬사용 program = new L06_07_좌표정렬_삽입정렬사용();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j<2; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        int[][] result = program.solution(n, arr);
        for (int[] location : result) {
            System.out.println(location[0] + " " + location[1]);
        }
    }
}

