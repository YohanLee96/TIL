package programmers;

import java.util.Arrays;

/**
 * Created by Yohan Lee. Created on 2024-02-28 <br/> 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. <br/> 예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자
 * "u", "e", "a"로 strings를 정렬합니다. <br/><br/>
 *
 * <h2>제한 조건</h2>
 * strings는 길이 1 이상, 50이하인 배열입니다.<br/> strings의 원소는 소문자 알파벳으로 이루어져 있습니다.<br/> strings의 원소는 길이 1 이상, 100이하인 문자열입니다.<br/> 모든 strings의 원소의 길이는 n보다 큽니다.<br/> 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에
 * 위치합니다.
 **/
public class L1_문자열_내_마음대로_정렬하기 {

    public static void main(String[] args) {
        L1_문자열_내_마음대로_정렬하기 program = new L1_문자열_내_마음대로_정렬하기();
        System.out.println(Arrays.toString(program.solution(new String[]{"sun", "bed", "car"}, 1)));
        System.out.println(Arrays.toString(program.solution(new String[]{"abce", "abcd", "cdx"}, 2)));
    }

    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings)
                     .sorted((s1, s2) -> {
                         if (s1.charAt(n) != s2.charAt(n)) {
                             return Character.compare(s1.charAt(n), s2.charAt(n));
                         }
                         return s1.compareTo(s2);
                     }).toArray(String[]::new);
    }
}
