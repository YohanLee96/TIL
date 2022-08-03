package inflearn.L01;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/07/28.
 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
 * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
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
