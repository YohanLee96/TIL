package inflearn;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/08/01.
 **/
public class L01_12_암호 {

    public String solution(String str , int chCount) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < chCount; i++) {
            //2진수로 변경
            String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2); //10진수로 변경
            answer.append((char)num); //ASCII번호에맞게 문자로 변경
            str = str.substring(7); //처리한 문자열 자르기
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        L01_12_암호 program = new L01_12_암호();
        Scanner kb = new Scanner(System.in);
        int chCount = Integer.parseInt(kb.nextLine());
        String str = kb.nextLine();
        System.out.println(program.solution(str, chCount));
    }
}
