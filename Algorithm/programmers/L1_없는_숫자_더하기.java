package programmers;

import java.util.Arrays;

/**
 * Created by Yohan lee Created on 2/8/24. <br/>
 * 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.  <br/>
 * numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.<br/>
 **/
public class L1_없는_숫자_더하기 {

    public static void main(String[] args) {
        L1_없는_숫자_더하기 program = new L1_없는_숫자_더하기();
        System.out.println(program.solution(new int[]{1,2,3,4,6,7,8,0}));;
        System.out.println(program.solution(new int[]{5,8,4,0,6,7,9}));;
    }

    public int solution(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }
}
