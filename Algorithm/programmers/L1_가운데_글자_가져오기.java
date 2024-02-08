package programmers;

/**
 * Created by Yohan lee Created on 2/8/24. <br/>
 * 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요.<br/>
 * 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
 **/
public class L1_가운데_글자_가져오기 {

    public static void main(String[] args) {
        L1_가운데_글자_가져오기 program = new L1_가운데_글자_가져오기();
        System.out.println(program.solution("abcde"));
        System.out.println(program.solution("qwer"));
    }

    public String solution(String s) {
        int midIndex = s.length() / 2;
        return s.length() % 2 == 0
               ? s.substring(midIndex -1, midIndex + 1)
               : String.valueOf(s.charAt(midIndex));
    }
}
