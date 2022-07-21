package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Yohan lee Created on 2022/07/21. 카카오에 입사한 신입 개발자 네오는 "카카오계정개발팀"에 배치되어, 카카오 서비스에 가입하는 유저들의 아이디를 생성하는 업무를 담당하게 되었습니다. "네오"에게 주어진 첫 업무는 새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때, 입력된 아이디와
 * 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발하는 것입니다. 다음은 카카오 아이디의 규칙입니다. 아이디의 길이는 3자 이상 15자 이하여야 합니다. 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다. 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다. 1단계
 * new_id의 모든 대문자를 대응되는 소문자로 치환합니다. 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다. 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다. 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
 * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다. 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다. 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다. 7단계 new_id의 길이가 2자 이하라면,
 * new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
 **/
public class L1_ID_Validation {


    public static void main(String[] args) {
        L1_ID_Validation program = new L1_ID_Validation();
        System.out.println(program.solution("...!@BaT#*..y.abcdefghijklm").equals("bat.y.abcdefghi"));
        System.out.println(program.solution("z-+.^.").equals("z--"));
        System.out.println(program.solution("=.=").equals("aaa"));
        System.out.println(program.solution("123_.def").equals("123_.def"));
        System.out.println(program.solution("abcdefghijklmn.p").equals("abcdefghijklmn"));
    }

    public String solution(String new_id) {
        //1단계
        String answer = filter1(new_id);
        answer = filter2(answer);
        answer = filter3(answer);
        answer = filter4(answer);
        answer = filter5(answer);
        answer = filter6(answer);
        answer = filter7(answer);

        return answer;
    }

    //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    private String filter1(String str) {
        return str.toLowerCase();
    }

    //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    private String filter2(String str) {
        Predicate<Character> validCharCondition = c -> c.equals('-')
                                                || c.equals('_')
                                                || c.equals('.')
                                                || (97 <= c && c <= 122)
                                                || Character.isDigit(c);
        List<Character> resultChars = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (validCharCondition.test(str.charAt(i))) {
                resultChars.add(str.charAt(i));
            }
        }

        StringBuilder builder = new StringBuilder(resultChars.size());
        for (Character resultChar : resultChars) {
            builder.append(resultChar);
        }

        return builder.toString();
    }

    //new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    private String filter3(String str) {
        String result = str.replace("..", ".");
        boolean inValid = true;
        while (inValid) {
            if(result.contains("..")) {
                result = result.replace("..", ".");
            } else {
                inValid = false;
            }
        }
        return result;
    }

    //new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    private String filter4(String str) {
        String result = str;
        if(result.indexOf(".") == 0) {
            result = str.substring(1);
        }
        if(result.length() == 0) {
            return result;
        }

        if(result.lastIndexOf(".") == result.length()-1) {
            result = result.substring(0, result.lastIndexOf("."));
        }
        return result;
    }

    //new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    private String filter5(String str) {
        if(str.equals("")) {
            str += "a";
        }
        return str;
    }

    /**
     * new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     * 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
     */
    private String filter6(String str) {
        String result = str;
        if(15 < str.length()) {
            result = str.substring(0, 15);
            if(result.lastIndexOf(".") == result.length() -1) {
                result = result.substring(0, result.lastIndexOf("."));
            }
        }
        return result;
    }

    private String filter7(String str) {
        final int MIN_STR_LENGTH = 3;
        if(str.length() < MIN_STR_LENGTH) {
            char lastChar = str.charAt(str.length() - 1);
            return str + String.valueOf(lastChar).repeat(MIN_STR_LENGTH - str.length());
        }
        return str;
    }
}
