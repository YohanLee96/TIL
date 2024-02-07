package programmers;

/**
 * Created by Yohan lee Created on 2/8/24. <br/>
 * 프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다. <br/>
 * 전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요. <br/>
 **/
public class L1_핸드폰_번호_가리기 {

    public static void main(String[] args) {
        L1_핸드폰_번호_가리기 program = new L1_핸드폰_번호_가리기();
        System.out.println(program.solution("01033334444"));
        System.out.println(program.solution("027778888"));
    }

    public String solution(String phone_number) {
        return "*".repeat(phone_number.length() - 4) + phone_number.substring(phone_number.length() - 4);
    }
}
