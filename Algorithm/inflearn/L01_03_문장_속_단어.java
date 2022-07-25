package inflearn;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/07/26.
 * 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
 * 문장속의 각 단어는 공백으로 구분됩니다.
 **/
public class L01_03_문장_속_단어 {


    public String solutionForIndexOf(String str) {
        String answer ="";
        int max = 0;
        int pos;
        while ((pos=str.indexOf(" ")) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len >max) {
                max = len;
                answer = tmp;
            }
            str = str.substring(pos+1);
        }
        if(str.length() > max) {
            answer = str;
        }
        return answer;
    }

    public String solution(String str) {
        String[] strArr = str.split(" ");
        int max = 0;
        String answer = "";
        for (String s : strArr) {
            if(max < s.length()) {
                max = s.length();
                answer = s;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        L01_03_문장_속_단어 program = new L01_03_문장_속_단어();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.print(program.solution(str));
        System.out.print(program.solutionForIndexOf(str));
    }


}
