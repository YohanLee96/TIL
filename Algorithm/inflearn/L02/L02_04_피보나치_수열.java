package inflearn.L02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/08/15.
 * 1) 피보나 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 **/
public class L02_04_피보나치_수열 {

    public int[] solution(int n) {
        int[] result = new int[n];
        for (int i = 0; i <n; i++) {
            if(i < 2) {
                result[i] = 1;
            } else {
                result[i] = result[i -2] + result[i-1];
            }
        }
        return result;
    }

    public void noArraySolution(int n) {
        int a =1, b = 1;
        int c;
        System.out.print(a+ " "+b+ " ");
        for (int i = 2; i < n; i++) {
            c = a+b;
            System.out.print(c + " ");
            a = b;
            b = c;

        }
    }

    public static void main(String[] args) {
        L02_04_피보나치_수열 program = new L02_04_피보나치_수열();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
//        for (int i : program.solution(num)) {
//            System.out.print(i + " ");
//        }

        program.noArraySolution(num);
    }
}
