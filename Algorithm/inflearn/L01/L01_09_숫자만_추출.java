package inflearn.L01;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/07/31.
 * 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
 * 만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
 * 추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
 **/
public class L01_09_숫자만_추출 {

    public int solutionForASCII(String str) {
        int result = 0;
        for (char c : str.toCharArray()) {
            if(48<=c && c<=57) {
                result = result * 10 + (c-48);
            }
        }
        return result;
    }


    public int solution(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if(Character.isDigit(c)) {
                result.append(c);
            }
        }
        return Integer.parseInt(result.toString());
    }

    public static void main(String[] args) {
        L01_09_숫자만_추출 program = new L01_09_숫자만_추출();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(program.solution(str));
    }
}
