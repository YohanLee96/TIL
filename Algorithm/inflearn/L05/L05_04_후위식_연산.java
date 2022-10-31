package inflearn.L05;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Yohan lee Created on 2022/10/27.
 * 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
 * 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
 *
 * Input
 * 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
 * 식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
 * Output
 * 연산한 결과를 출력합니다.
 **/
public class L05_04_후위식_연산 {

    public int solution(String expression) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if(Character.isDigit(c)) {
                stack.push(c-48);
            } else {
                int last = stack.pop();
                int next = stack.pop();
                switch (c) {
                    case '+' -> stack.push(last + next);
                    case '-' -> stack.push(next - last);
                    case '*' -> stack.push(last * next);
                    case '/' -> stack.push(next / last);
                }
            }
        }
        return stack.peek();
    }


    public static void main(String[] args) {
        L05_04_후위식_연산 program = new L05_04_후위식_연산();
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine();
        System.out.println(program.solution(s));
    }
}
