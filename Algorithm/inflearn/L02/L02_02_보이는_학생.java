package inflearn.L02;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/08/07.
 * 선생님이 N명의 학생을 일렬로 세웠습니다.
 * 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때,
 * 맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요.
 * (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
 **/
public class L02_02_보이는_학생 {


    public int solution(int n, int[] students) {
        int result = 1;
        int biggest = students[0];
        for (int i = 1; i < students.length; i++) {
            if(biggest < students[i]) {
                biggest = students[i];
                result++;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        L02_02_보이는_학생 program = new L02_02_보이는_학생();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(program.solution(n, arr));
    }
}
