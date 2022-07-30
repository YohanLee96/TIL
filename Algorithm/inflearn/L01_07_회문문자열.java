package inflearn;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/07/30.
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
 * 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 * 단 회문을 검사할 때 대소문자를 구분하지 않습니다.
 **/
public class L01_07_회문문자열 {

    public String solutionForIndexFor(String str) {
        String lowerStr = str.toLowerCase();
        int length = str.length();
        char[] chars = lowerStr.toCharArray();
        for (int i = 0; i < length / 2; i++) {
            if(lowerStr.charAt(i) != lowerStr.charAt(length -1 - i)) {
                return "NO";
            }
        }

        return "YES";
    }

    public String solutionForBuilder(String str) {
        String reverseStr = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(reverseStr)) {
            return "YES";
        }

        return "NO";
    }


    public String mySolution(String str) {
        String lowerStr = str.toLowerCase();
        char[] chars = lowerStr.toCharArray();
        int lt = 0;
        int rt = lowerStr.length() -1;
        while (lt < rt) {
            if(chars[lt] != chars[rt]) {
                return "NO";
            }
            lt++;
            rt--;
        }

        return "YES";
    }

    public static void main(String[] args) {
        L01_07_회문문자열 program = new L01_07_회문문자열();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(program.mySolution(str));
    }



}
