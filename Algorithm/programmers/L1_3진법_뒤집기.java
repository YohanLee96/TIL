package programmers;

import java.util.stream.IntStream;

/**
 * Created by Yohan Lee. Created on 2024-02-20 <br/>
 * 자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
 **/
public class L1_3진법_뒤집기 {

    public static void main(String[] args) {
        L1_3진법_뒤집기 program = new L1_3진법_뒤집기();
        System.out.println(program.solution(45));
        System.out.println(program.solution(125));
    }

    public int solution(int n) {
        if(n < 4) {
            return n;
        }
        int answer = 0;
        int tmp = n;
        StringBuilder builder = new StringBuilder();
        while (0 < tmp) {
            builder.append(tmp%3);
            tmp = tmp /3;
        }
        String[] digits = builder.reverse().toString().split("");
        answer += Integer.parseInt(digits[0]);
        for (int i = 1; i < digits.length; i++) {
            answer += (int)Math.pow(3, i) * Integer.parseInt(digits[i]);
        }
        return answer;
    }
}
