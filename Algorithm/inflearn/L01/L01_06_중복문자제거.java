package inflearn.L01;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/07/29.
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
 * 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 **/
public class L01_06_중복문자제거 {

    public String solution(String str) {

        char[] chars = str.toCharArray();
        int length = chars.length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <length;i++) {
            if(i == str.indexOf(chars[i])) { //현재 인덱스와 indexOf()로 찾은 문자의 인덱스가 맞지 않으면 중복이다.
                builder.append(chars[i]);
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        L01_06_중복문자제거 program = new L01_06_중복문자제거();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(program.solution(str));
    }
}
