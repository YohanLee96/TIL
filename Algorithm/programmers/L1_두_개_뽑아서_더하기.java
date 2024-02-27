package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yohan Lee. Created on 2024-02-28 <br/> 정수 배열 numbers가 주어집니다. <br/> numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
 **/
public class L1_두_개_뽑아서_더하기 {

    public static void main(String[] args) {
        L1_두_개_뽑아서_더하기 program = new L1_두_개_뽑아서_더하기();
        System.out.println(Arrays.toString(program.solution(new int[]{2, 1, 3, 4, 1})));
        System.out.println(Arrays.toString(program.solution(new int[]{5, 0, 2, 7})));
        System.out.println(Arrays.toString(program.solution(new int[]{0, 0})));
    }

    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (i < numbers.length - 1 && numbers[i] == numbers[i + 1]) {
                set.add(numbers[i] + numbers[i + 1]);
                while (i < numbers.length - 1 && numbers[i] == numbers[i + 1]) {
                    i++;
                }
            }
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set.stream()
                  .sorted()
                  .mapToInt(Integer::intValue)
                  .toArray();
    }
}
