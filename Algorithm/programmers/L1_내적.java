package programmers;

import java.util.stream.IntStream;

/**
 * Created by Yohan lee Created on 2/8/24. <br/> 길이가 같은 두 1차원 정수 배열 a, b가 매개변수로 주어집니다. <br/> a와 b의 내적을 return 하도록 solution 함수를 완성해주세요. <br/> 이때, a와 b의 내적은 a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1]
 * 입니다. (n은 a, b의 길이) <br/>
 **/
public class L1_내적 {

    public static void main(String[] args) {
        L1_내적 program = new L1_내적();
        System.out.println(program.solution(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2}));
        System.out.println(program.solution(new int[]{-1, 0, 1}, new int[]{1, 0, -1}));
    }

    public int solution(int[] a, int[] b) {
        return IntStream.range(0, a.length)
                        .map(index -> a[index] * b[index])
                        .sum();
    }
}
