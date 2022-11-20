package programmers;

/**
 * Created by Yohan lee Created on 2022/11/20.
 * 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
 * n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
 * n은 1이상, 50000000000000 이하인 양의 정수입니다.
 **/
public class L1_정수_제곱근_판별 {

    public static void main(String[] args) {
        System.out.println(solution(121)); //144
        System.out.println(solution(3)); //-1
    }

    public static long solution(long n) {
        long answer = -1;
        for (long i = 1; i * i <= n; i++) {
            if(i*i == n) {
                return (long)Math.pow(i+1, 2);
            }
        }
        return answer;
    }
}
