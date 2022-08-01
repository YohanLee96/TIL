package inflearn;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/08/01.
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 * 단 반복횟수가 1인 경우 생략합니다.
 **/
public class L01_11_문자열압축 {

    public String solution(String str) {
        StringBuilder builder = new StringBuilder();
        char nowCh = 'a';
        int cnt = 1;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == nowCh) { //동일하면 카운터 추가
                cnt++;
            }else {
                if(cnt != 1) { //반복문자가 있다면 카운트 append
                    builder.append(cnt); //반복횟수 추가
                    cnt = 1; //다시 1로 초기화
                }
                builder.append(str.charAt(i));
                nowCh = str.charAt(i);
            }
        }
        if(1 < cnt) { //마지막 카운트가 추가됬다면 append
            builder.append(cnt);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        L01_11_문자열압축 program = new L01_11_문자열압축();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(program.solution(str));
        System.out.println(program.solution("KKHSSSSSSSE"));
//        System.out.println(program.solution("KSTTTSEEKFKKKDJJGG"));
    }
}
