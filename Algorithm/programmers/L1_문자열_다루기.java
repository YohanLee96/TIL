package programmers;

/**
 * Created by Yohan Lee. Created on 2024-02-16 <br/>
 * 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. <br/>
 * 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
 **/
public class L1_문자열_다루기 {

    public static void main(String[] args) {
        L1_문자열_다루기 program = new L1_문자열_다루기();
        System.out.println(program.solution("a234"));
        System.out.println(program.solution("1234"));
    }

    public boolean solution(String s) {
        if(s.length() != 4 && s.length() != 6) {
            return false;
        }
        for (char c : s.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
