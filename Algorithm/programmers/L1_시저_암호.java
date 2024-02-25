package programmers;

/**
 * Created by Yohan Lee. Created on 2024-02-25 <br/>
 * 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.  <br/>
 * 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다.  <br/>
 * "z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요 <br/>
 **/
public class L1_시저_암호 {
    public static void main(String[] args) {
        L1_시저_암호 program = new L1_시저_암호();
        System.out.println(program.solution("AB", 1));
        System.out.println(program.solution("z", 1));
        System.out.println(program.solution("a B z", 4));
        System.out.println(program.solution("ZZ", 25));
    }

    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c == ' ') {
                answer.append(" ");
                continue;
            }
            char cipher = (char)(c+ n);

            if((Character.isLowerCase(c) && 122 < cipher)) { //소문자 처리
                cipher = (char)(96 + (cipher % 122));
            } else if (Character.isUpperCase(c) && 90 < cipher) {  //대문자 처리
                cipher = (char)(64 + (cipher % 90));
            }
            answer.append(cipher);
        }
        return answer.toString();
    }
}
