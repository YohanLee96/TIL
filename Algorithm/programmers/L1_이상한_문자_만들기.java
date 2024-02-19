package programmers;

/**
 * Created by Yohan Lee. Created on 2024-02-20 <br/>
 * 문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.  <br/>
 * 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
 **/
public class L1_이상한_문자_만들기 {
    public static void main(String[] args) {
        L1_이상한_문자_만들기 program = new L1_이상한_문자_만들기();
        System.out.println(program.solution("try hello world"));
        System.out.println(program.solution("t"));
        System.out.println(program.solution("TT  TT"));
    }

    public String solution(String s) {
        if(s.length() == 1) return s.toUpperCase();
        StringBuilder answer = new StringBuilder();
        String[] sliceStrs = s.split(" ", -1);
        for (int i = 0; i < sliceStrs.length; i++) {
            String sliceStr = sliceStrs[i];
            if (!sliceStr.isEmpty()) {
                char[] chars = sliceStr.toCharArray();
                answer.append(Character.toUpperCase(chars[0]));
                for (int j = 1; j < chars.length; j++) {
                    if (j % 2 == 0) {
                        answer.append(Character.toUpperCase(chars[j]));
                    } else {
                        answer.append(Character.toLowerCase(chars[j]));
                    }
                }

            }
            if(i < sliceStrs.length -1) {
                answer.append(" ");
            }
        }
        return answer.toString();
    }
}
