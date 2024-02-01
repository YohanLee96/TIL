package programmers;

import java.util.Arrays;

/**
 * Created by Yohan lee Created on 2/2/24.
 **/
public class L1_x만큼_간격이_있는_n개의_숫자 {
    public static void main(String[] args) {
        L1_x만큼_간격이_있는_n개의_숫자 program = new L1_x만큼_간격이_있는_n개의_숫자();
        System.out.println(Arrays.toString(program.solution(2, 5)));
        System.out.println(Arrays.toString(program.solution(4,3)));
        System.out.println(Arrays.toString(program.solution(-4, 2)));
    }

    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] +x;
        }
        return answer;
    }
}
