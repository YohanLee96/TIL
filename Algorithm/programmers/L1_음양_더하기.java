package programmers;

/**
 * Created by Yohan lee Created on 2/6/24. <br/>
 * 어떤 정수들이 있습니다. 이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와 이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어집니다.<br/>
 * 실제 정수들의 합을 구하여 return 하도록 solution 함수를 완성해주세요. <br/>
 **/
public class L1_음양_더하기 {

    public static void main(String[] args) {
        L1_음양_더하기 program = new L1_음양_더하기();
        System.out.println(program.solution(new int[]{4, 7, 12}, new boolean[]{true, false, true}));
        System.out.println(program.solution(new int[]{1, 2, 3}, new boolean[]{false, false, true}));
    }

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            answer += signs[i] ? absolutes[i] : -absolutes[i];
        }
        return answer;
    }
}
