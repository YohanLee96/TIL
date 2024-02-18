package programmers;

import java.util.Arrays;

/**
 * Created by Yohan Lee. Created on 2024-02-18 <br/>
 * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. <br/>
 * 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. <br/>
 * 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
 **/
public class L1_최대공약수와_최소공배수 {

    public static void main(String[] args) {
        L1_최대공약수와_최소공배수 program = new L1_최대공약수와_최소공배수();
        System.out.println(Arrays.toString(program.solution(3, 12)));
        System.out.println(Arrays.toString(program.solution(2, 5)));
    }
    public int[] solution(int n, int m) {
        int maxDiv = 1;
        int minMul = 1;
        int max = Math.max(n, m);
        if(max == 1) {
            return new int[] {maxDiv, minMul};
        }
        for (int i = 1; i <= Math.min(n, m); i++) {
            if(n % i == 0 && m % i == 0) {
                maxDiv = i;
                minMul = n * m / i;
            }
        }
        return new int[]{maxDiv, minMul};
    }
}
