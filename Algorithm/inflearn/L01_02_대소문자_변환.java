package inflearn;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/07/25.
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
 **/
public class L01_02_대소문자_변환 {

    //ASCII Code -> 대문자 65~90, 소문자 97~122
    public String solutionForASCII(String str) {
        StringBuilder builder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if(c >=65 && c <=90) {
                builder.append((char)(c + 32));
            } else {
                builder.append((char)(c-32));
            }
        }

        return builder.toString();
    }

    public String solution(String str) {
        StringBuilder builder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if(Character.isUpperCase(c)) {
                builder.append(Character.toLowerCase(c));
            } else {
                builder.append(Character.toUpperCase(c));
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        L01_02_대소문자_변환 program = new L01_02_대소문자_변환();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(program.solution(str));
        System.out.print(program.solutionForASCII(str));
    }
}
