package programmers;

/**
 * Created by Yohan lee Created on 2/2/24.
 **/
public class L1_문자열을_정수로_바꾸기 {
    public static void main(String[] args) {
        L1_문자열을_정수로_바꾸기 program =   new L1_문자열을_정수로_바꾸기();
        System.out.println(program.solution("1234"));
        System.out.println(program.solution("-1234"));
    }

    public int solution(String s) {
        return Integer.parseInt(s);
    }
}
