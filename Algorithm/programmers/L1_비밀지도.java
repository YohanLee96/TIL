package programmers;

import java.util.Arrays;

/**
 * Created by Yohan Lee. Created on 2024-03-01 <br/> 네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다.  <br/> 그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다.  <br/> 다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.
 * <br/> <br/> 1. 지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다. <br/> 2. 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 "지도 1"과 "지도 2"라고 하자. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 지도 1과
 * 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다. <br/> 3. "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다. <br/> 4. 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다. <br/><br/> 네오가 프로도의 비상금을 손에 넣을 수 있도록,
 * 비밀지도의 암호를 해독하는 작업을 도와줄 프로그램을 작성하라.
 **/
public class L1_비밀지도 {

    public static void main(String[] args) {
        L1_비밀지도 program = new L1_비밀지도();
                System.out.println(Arrays.toString(program.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
                System.out.println(Arrays.toString(program.solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10})));
        System.out.println(Arrays.toString(program.solution(1, new int[]{234234}, new int[]{0})));
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String binary = Integer.toBinaryString(arr1[i] | arr2[i]);
            String paddingBinary = String.format("%" + n + "s", binary)
                                         .replace(' ', '0');
            answer[i] = paddingBinary
                .replace('1', '#')
                .replace('0', ' ');
        }
        return answer;
    }


}
