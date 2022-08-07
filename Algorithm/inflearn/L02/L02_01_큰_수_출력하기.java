package inflearn.L02;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/08/03.
 * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
 * (첫 번째 수는 무조건 출력한다)
 **/
public class L02_01_큰_수_출력하기 {


    public ArrayList<Integer> solution(int n, int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] < nums[i]) {
                list.add(nums[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        L02_01_큰_수_출력하기 program = new L02_01_큰_수_출력하기();
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
