package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Yohan Lee. Created on 2024-02-14 <br/> 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요. <br/>
 * s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
 **/
public class L1_문자열_내림차순으로_배치하기 {

    public static void main(String[] args) {
        L1_문자열_내림차순으로_배치하기 program = new L1_문자열_내림차순으로_배치하기();
        System.out.println(program.solution("Zbcdefg"));
    }

    public String solution(String s) {
        return Stream.of(s.split(""))
                     .sorted(Collections.reverseOrder())
                     .collect(Collectors.joining());
    }
}
