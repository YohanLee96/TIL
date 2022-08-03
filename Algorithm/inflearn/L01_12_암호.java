package inflearn;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/08/01.
 **/
public class L01_12_암호 {

    public String solution(String str, int chCount) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <str.length() ; i++) {
            if(i % 7 == 0 && i != 0) {
                builder.append(' ');
            }
            char c= str.charAt(i);
            if(c == '#') builder.append('1');
            else builder.append('0');
        }
        String[] arr = builder.toString().split(" ");
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            int decimalNum = Integer.parseInt(s, 2);
            result.append((char)decimalNum);
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        L01_12_암호 program = new L01_12_암호();
        Scanner kb = new Scanner(System.in);
        int chCount = Integer.parseInt(kb.nextLine());
        String str = kb.nextLine();
        System.out.println(program.solution(str, chCount));
    }
}
