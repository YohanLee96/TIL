package programmers;

/**
 * Created by Yohan lee Created on 2022/11/20.
 * 정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
 **/
public class L1_짝수와_홀수 {

    public String solution(int num) {
        return num %2 == 0 ? "Even" : "Odd";
    }
}
