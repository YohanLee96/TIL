package programmers;

/**
 * Created by Yohan lee Created on 2022/11/20.
 * 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
 * 예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
 **/
public class L1_자릿수_더하기 {

    public static void main(String[] args) {
        System.out.println(solution(123));
    }

    public static int solution(int n) {
        int answer = 0;
        for (char c : String.valueOf(n).toCharArray()) {
            answer += c-48;
        }
        return answer;
    }

}
