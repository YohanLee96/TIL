package inflearn.L03;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by Yohan lee Created on 2022/09/20.
 **/
public class L03_06_연속된_자연수의_합_수학 {

    public int solution(int n) {
        int result = 0, cnt =1;
        n--;
        while (0 < n) {
            cnt++;
            n = n -cnt;
            if(n%cnt == 0) result++;
        }
        return result;

    }

    public static void main(String[] args) {
        L03_06_연속된_자연수의_합_수학 program = new L03_06_연속된_자연수의_합_수학();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(program.solution(n));
    }
}
