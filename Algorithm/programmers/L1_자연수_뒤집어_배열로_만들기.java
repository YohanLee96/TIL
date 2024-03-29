package programmers;

import java.util.Arrays;

/**
 * Created by Yohan lee Created on 2022/07/24.
 * 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
 * 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
 **/
public class L1_자연수_뒤집어_배열로_만들기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(12345)));
        System.out.println(Arrays.toString(solution2(12345)));
    }

    public static int[] solution(long n) {
        char[] chars = String.valueOf(n).toCharArray();
        int[] answer = new int[chars.length];
        int answerIndex = 0;
        for (int i = chars.length-1; 0 <= i; i--) {
            answer[answerIndex] = Character.getNumericValue(chars[i]);
            answerIndex++;
        }

        return answer;

    }

    //10씩 나눈 나머지를 구해서 푸는 솔루션.
    public static int[] solution2(long n) {
        String a = "" + n;
        int[] answer = new int[a.length()];
        int cnt=0;

        while(n>0) {
            answer[cnt]=(int)(n%10);
            n/=10;
            System.out.println(n);
            cnt++;
        }
        return answer;
    }
}
