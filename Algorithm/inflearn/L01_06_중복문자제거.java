package inflearn;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/07/29.
 **/
public class L01_06_중복문자제거 {

    public String solution(String str) {

        char[] chars = str.toCharArray();
        int length = chars.length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <length;i++) {
            if(i == length -1) {
                builder.append(chars[i]);
                break;
            }
            if(chars[i] != chars[i+1]) {
                builder.append(chars[i]);
            } else {
                i = i +2; //중복점프
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        L01_06_중복문자제거 program = new L01_06_중복문자제거();
//        Scanner kb = new Scanner(System.in);
//        String str = kb.nextLine();
        System.out.println(program.solution("ksekkset"));
    }
}
