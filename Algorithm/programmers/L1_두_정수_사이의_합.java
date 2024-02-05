package programmers;

/**
 * Created by Yohan lee Created on 2/6/24. <br/>
 * 두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요. <br/>
 * 예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
 **/
public class L1_두_정수_사이의_합 {
    public static void main(String[] args) {
        L1_두_정수_사이의_합 program = new L1_두_정수_사이의_합();
        System.out.println(program.solution(3, 5));
        System.out.println(program.solution(3, 3));
        System.out.println(program.solution(5, 3));
    }

    public long solution(int a, int b) {
        long answer = 0;
        if(a == b) {
            return a;
        }
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        for (int i = min; i <= max; i++) {
            answer += i;
        }
        return answer;
    }
}
