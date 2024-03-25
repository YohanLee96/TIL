package programmers;

/**
 * Created by Yohan Lee. Created on 2024-03-23 <br/>
 * 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.
 * 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때,
 * nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
 * <hr/>
 * <ul>
 *    <li>nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.</li>
 *    <li>nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.</li>
 * </ul>
 **/
public class L1_소수_만들기 {

    public static void main(String[] args) {
        L1_소수_만들기 program = new L1_소수_만들기();
        System.out.println(program.solution(new int[]{1, 2, 3, 4})); //1
        System.out.println(program.solution(new int[]{1, 2, 7, 6, 4})); //4
    }

    public int solution(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    boolean isPrime = true;
                    for (int l = 2; l <= Math.sqrt(sum); l++) {
                        if(sum % l == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if(isPrime) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
