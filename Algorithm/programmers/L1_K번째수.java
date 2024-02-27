package programmers;

import java.util.Arrays;

/**
 * Created by Yohan Lee. Created on 2024-02-25 <br/> 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다. <br/>
 * <p>
 * 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면 <br/>
 * <p>
 * 1. array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다. <br/> 2. 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다. <br/> 3. 2에서 나온 배열의 3번째 숫자는 5입니다. <br/> 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든
 * 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 **/
public class L1_K번째수 {

    public static void main(String[] args) {
        L1_K번째수 program = new L1_K번째수();
        System.out.println(Arrays.toString(program.solution(
                                               new int[]{1, 5, 2, 6, 3, 7, 4},
                                               new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}
                                           )
        ));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int start = command[0];
            int end = command[1];
            int position = command[2] - 1;

            int[] splitArr = new int[end - start + 1];
            int index = 0;
            for (int j = start -1; j < end; j++) {
                splitArr[index++] = array[j];
            }
            Arrays.sort(splitArr);
            answer[i] = splitArr[position];
        }
        return answer;
    }
}
