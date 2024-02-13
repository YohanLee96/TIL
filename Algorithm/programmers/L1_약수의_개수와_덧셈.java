package programmers;

/**
 * Created by Yohan Lee. Created on 2024-02-14 <br/>
 * 두 정수 left와 right가 매개변수로 주어집니다. <br/>
 * left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
 **/
public class L1_약수의_개수와_덧셈 {
    public static void main(String[] args) {
        L1_약수의_개수와_덧셈 program = new L1_약수의_개수와_덧셈();
        System.out.println(program.solution(13, 17));
        System.out.println(program.solution(24, 27));
    }

    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int divisorCount = i == 1 ? 1 : 2;
            for (int j = 2; j <= i/2; j++) {
                if(i % j == 0) {
                    divisorCount++;
                }
            }
            if(divisorCount % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }
}
