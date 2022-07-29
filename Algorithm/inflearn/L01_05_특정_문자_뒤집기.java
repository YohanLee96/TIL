package inflearn;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/07/28.
 **/
public class L01_05_특정_문자_뒤집기 {

    public String solution(String str) {
        char[] chars = str.toCharArray();
        int lt = 0;
        int rt = chars.length -1;
        while(lt< rt) {
            String regax = "[^a-zA-Z\\d\\s]";
            if(Character.isAlphabetic(chars[lt])) { //왼쪽문자가 특수문자일 경우,
                lt++;
            } else if(Character.isAlphabetic(chars[rt])) { //오른쪽문자가 특수문자일 경우,
                rt--;
            } else {
                char temp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = temp;
                lt++;
                rt--;
            }
        }

        return String.valueOf(chars);
    }


    public static void main(String[] args) {
        L01_05_특정_문자_뒤집기 program = new L01_05_특정_문자_뒤집기();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(program.solution(str));
    }
}
