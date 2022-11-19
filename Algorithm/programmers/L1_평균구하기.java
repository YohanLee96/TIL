package programmers;

/**
 * Created by Yohan lee Created on 2022/11/20.
 * 정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.
 **/
public class L1_평균구하기 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(solution(arr));;
    }

    public static double solution(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return (double)sum/ arr.length;
    }
}
