package programmers;

import java.util.Arrays;

/**
 * Created by Yohan lee Created on 2/8/24. <br/> 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. <br/> 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고,
 * [10]면 [-1]을 리턴 합니다.
 **/
public class L1_제일_작은_수_제거하기 {

    public static void main(String[] args) {
        L1_제일_작은_수_제거하기 program = new L1_제일_작은_수_제거하기();
        System.out.println(Arrays.toString(program.solution(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(program.solution(new int[]{5, 1, 3, 4})));
        System.out.println(Arrays.toString(program.solution(new int[]{10})));
    }

    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        int[] answer = new int[arr.length - 1];
        int minIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIdx]) {
                minIdx = i;
            }
        }
        int arrIdx = 0;
        for (int i = 0; i < answer.length; i++) {
            if (arrIdx != minIdx) {
                answer[i] = arr[arrIdx];
            } else {
                answer[i] = arr[++arrIdx];
            }
            arrIdx++;
        }
        return answer;
    }
}
