package programmers;

import java.util.Arrays;

/**
 * Created by Yohan Lee. Created on 2024-02-25 <br/> 문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, <br/> 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지 알고 싶습니다.<br/> 예를 들어, s="banana"라고 할 때,  각 글자들을 왼쪽부터 오른쪽으로 읽어 나가면서 다음과
 * 같이 진행할 수 있습니다.<br/> 문자열 s이 주어질 때, 위와 같이 정의된 연산을 수행하는 함수 solution을 완성해주세요.
 **/
public class L1_가장_가까운_글자 {

    public static void main(String[] args) {
        L1_가장_가까운_글자 program = new L1_가장_가까운_글자();
        System.out.println(Arrays.toString(program.solution("banana")));
        System.out.println(Arrays.toString(program.solution("foobar")));
        System.out.println(Arrays.toString(program.solution("aaaaa")));
        System.out.println(Arrays.toString(program.solution("dfdfdf")));
        System.out.println(Arrays.toString(program.solution("qwertyi")));
    }

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;
        for (int i = 1; i < s.length(); i++) {
            int d = -1;
            for (int j = i -1; 0 <= j; j--) {
                if(s.charAt(i) == s.charAt(j)) {
                    d = i - j;
                    break;
                }
            }
            answer[i] = d;
        }
        return answer;
    }
}
