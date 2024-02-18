package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Yohan Lee. Created on 2024-02-18 <br/>
 * 배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. <br/>
 * 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. <br/>
 * 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면, <br/>
 * arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다. <br/>
 * arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다. <br/>
 * 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요. <br/>
 **/
public class L1_같은_숫자는_싫어 {
    public static void main(String[] args) {
        L1_같은_숫자는_싫어 program = new L1_같은_숫자는_싫어();
        System.out.println(Arrays.toString(program.solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
        System.out.println(Arrays.toString(program.solution(new int[]{4, 4, 4, 3, 3})));
    }

    public int[] solution(int[] arr) {
        if(arr.length < 2) {
            return arr;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(arr[0]);
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != prev) {
                prev = arr[i];
                queue.offer(arr[i]);
            }
        }
        int[] answer = new int[queue.size()];
        int index = 0;
        while (!queue.isEmpty()) {
            answer[index++] = queue.poll();
        }
        return answer;
    }
}
