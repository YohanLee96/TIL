package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Created by Yohan Lee. Created on 2024-03-23 <br/> 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다. <hr/> 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * <br/> 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ... <br/> 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ... <br/> <hr/> 1번 문제부터 마지막 문제까지의 정답이 순서대로
 * 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 **/
public class L1_모의고사 {

    public static void main(String[] args) {
        L1_모의고사 program = new L1_모의고사();
        System.out.println(Arrays.toString(program.solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(program.solution(new int[]{1, 3, 2, 4, 2})));
    }

    /**
     * 1, 2, 3, 4, 5 2, 1, 2, 3, 2, 4, 2, 5 3, 3, 1, 1, 2, 2, 4, 4, 5, 5
     */
    public int[] solution(int[] answers) {
        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int s1Score = 0;
        int s2Score = 0;
        int s3Score = 0;
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (answer == s1[calIndex(s1.length, i)]) {
                s1Score++;
            }
            if (answer == s2[calIndex(s2.length, i)]) {
                s2Score++;
            }
            if (answer == s3[calIndex(s3.length, i)]) {
                s3Score++;
            }
        }
        if (s1Score == 0 && s2Score == 0 && s3Score == 0) {
            return new int[]{};
        } else if ((s1Score == s2Score) && (s2Score == s3Score)) {
            return new int[]{1, 2, 3};
        }

        int max = Math.max(Math.max(s1Score, s2Score), s3Score);
        List<Integer> list = new ArrayList<>();
        if (max == s1Score) {
            list.add(1);
        }
        if (max == s2Score) {
            list.add(2);
        }
        if (max == s3Score) {
            list.add(3);
        }
        return list.stream()
                   .mapToInt(value -> value)
                   .toArray();
    }

    private int calIndex(int arrLength, int nowIndex) {
        if (nowIndex == 0) {
            return 0;
        }
        return nowIndex % arrLength;
    }
}
