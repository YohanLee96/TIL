package inflearn.L05;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Yohan lee Created on 2022/10/21.
 * 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
 * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
 *
 * Input
 * 첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
 *
 * Output
 * 첫 번째 줄에 YES, NO를 출력한다.
 **/
public class L05_01_올바른_괄호 {

    /**
     * push() : 스택에 추가.
     * pop() : 스택에 맨위에 있는 개체를 가져오고 제거합니다.
     * peek() : 스택에 맨위에 있는 개체를 가져오기만 합니다.
     */

    public String solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) { // 없을 경우, 짝이 맞지않음.
                    return "NO";
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()) {
            return "NO";
        }

        return "YES";
    }

    public static void main(String[] args) {
        L05_01_올바른_괄호 program = new L05_01_올바른_괄호();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        System.out.println(program.solution(s));
    }
}
