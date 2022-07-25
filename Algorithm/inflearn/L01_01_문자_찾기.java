package inflearn;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/07/25.
 * 01-01 문자찾기
 * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
 **/
public class L01_01_문자_찾기 {

    public int solution(String str, char ch) {
        int answer = 0;
        str = str.toUpperCase();
        ch=Character.toUpperCase(ch);
        for (char c : str.toCharArray()) {
            if(c == ch) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        L01_01_문자_찾기 program = new L01_01_문자_찾기();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.print(program.solution(str, c));
    }
}
