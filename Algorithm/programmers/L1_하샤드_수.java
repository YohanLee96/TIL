package programmers;

/**
 * Created by Yohan lee Created on 2/6/24.
 *
 * 양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. <br/>
 * 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. <br/>
 * 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요. <br/>
 **/
public class L1_하샤드_수 {
    public static void main(String[] args) {
        L1_하샤드_수 program = new L1_하샤드_수();
        System.out.println(program.solution(10));
        System.out.println(program.solution(12));
        System.out.println(program.solution(11));
        System.out.println(program.solution(13));
    }

    public boolean solution(int x) {

        char[] charArray = String.valueOf(x).toCharArray();
        if(charArray.length == 1) {
            return true;
        }
        int sum = 0;
        for (char c : charArray) {
            sum += c-48;
        }
        return x % sum == 0;
    }
}
