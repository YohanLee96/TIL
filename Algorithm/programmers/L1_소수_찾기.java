package programmers;

/**
 * Created by Yohan Lee. Created on 2024-03-23 <br/>
 * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
 * 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
 * (1은 소수가 아닙니다.)
 **/
public class L1_소수_찾기 {

    public static void main(String[] args) {
        L1_소수_찾기 program = new L1_소수_찾기();
        System.out.println(program.solution(10)); //4
        System.out.println(program.solution(5)); //3
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) answer++;
        }
        return answer;
    }
}
