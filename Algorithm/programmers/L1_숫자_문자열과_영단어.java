package programmers;

import java.util.Map;

/**
 * Created by Yohan Lee. Created on 2024-02-25 <br/> 네오와 프로도가 숫자놀이를 하고 있습니다.  <br/> 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.  <br/> 다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다. <br/> 1478
 * → "one4seveneight" <br/> 234567 → "23four5six7" <br/> 10203 → "1zerotwozero3" <br/> 이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다.  <br/> s가 의미하는 원래 숫자를 return 하도록 solution 함수를
 * 완성해주세요.  <br/>
 **/
public class L1_숫자_문자열과_영단어 {
    public static void main(String[] args) {
        L1_숫자_문자열과_영단어 program = new L1_숫자_문자열과_영단어();
        System.out.println(program.solution("one4seveneight"));
        System.out.println(program.solution("23four5six7"));
        System.out.println(program.solution("2three45sixseven"));
        System.out.println(program.solution("123"));
    }


    private static final Map<String, String> NUM_MAP = Map.of(
        "zero", "0",
        "one", "1",
        "two", "2",
        "three", "3",
        "four", "4",
        "five", "5",
        "six", "6",
        "seven", "7",
        "eight", "8",
        "nine", "9"
    );

    public int solution(String s) {
        StringBuilder builder = new StringBuilder();
        StringBuilder test = new StringBuilder();
        for (char c : s.toCharArray()) {
            String num = NUM_MAP.get(test.toString());
            if (num != null) {
                builder.append(num);
                test = new StringBuilder();
            }
            if (Character.isDigit(c)) {
                builder.append(c);
            } else {
                test.append(c);
            }
        }
        if(test.length() != 0) {
            String num = NUM_MAP.get(test.toString());
            if (num != null) {
                builder.append(num);
            }
        }
        return Integer.parseInt(builder.toString());
    }


}

