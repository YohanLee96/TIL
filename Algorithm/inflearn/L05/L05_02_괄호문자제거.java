package inflearn.L05;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Yohan lee Created on 2022/10/23.
 * 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
 * Input
 * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 *
 * Output
 * 남은 문자만 출력한다.
 **/
public class L05_02_괄호문자제거 {

    public String answerSolution(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == ')') {
                while (stack.peek() == '(') {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        for (Character character : stack) {
            result.append(character);
        }

        return result.toString();
    }

    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else if(c == ')') {
                stack.pop();
            } else if(stack.size() == 0) {
                result.append(c);
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {
        L05_02_괄호문자제거 program = new L05_02_괄호문자제거();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        System.out.println(program.solution(s));
    }
}
