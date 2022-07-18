package programmers;

import java.util.Arrays;

/**
 * 나누어 떨어지는 숫자 배열
 * Created by Yohan lee Created on 2022/07/19.
 * array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
 * divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
 **/
public class L1_divisible_array_of_numbers {

    public static void main(String[] args) {
        int[] answer1 = solution(new int[]{5, 9, 7, 10}, 5);
        System.out.println(Arrays.toString(answer1));
        int[] answer2 = solution(new int[]{2, 36, 1, 3}, 1);
        System.out.println(Arrays.toString(answer2));
        int[] answer3 = solution(new int[]{3,2,6}, 10);
        System.out.println(Arrays.toString(answer3));
    }


    public static int[] solution(int[] arr, int divisor) {
        int[] answer = new int[arr.length];
        boolean exist = false;
        int noDivideCount = 0;
        for (int i =0; i<arr.length; i++) {
            if(arr[i] % divisor == 0) {
                exist = true;
                answer[i] = arr[i];
            } else {
                ++noDivideCount;
            }
        }

        if(!exist) {
            return new int[]{-1};
        }

        Arrays.sort(answer, 0, answer.length);

        return Arrays.copyOfRange(answer, noDivideCount, answer.length);
    }

}
