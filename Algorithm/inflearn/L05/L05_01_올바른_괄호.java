package inflearn.L05;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/10/21.
 * 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
 * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
 *
 * Input
 * 첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
 *
 * Output
 * 첫 번째 줄에 YES, NO를 출력한다.
 **/
public class L05_01_올바른_괄호 {

    public String solution(String s) {
        String result = "YES";

        return result;
    }

    public static void main(String[] args) {
        L05_01_올바른_괄호 program = new L05_01_올바른_괄호();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        System.out.println(program.solution(s));
    }
}
