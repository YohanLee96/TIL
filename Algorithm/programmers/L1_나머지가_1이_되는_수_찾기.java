package programmers;

/**
 * Created by Yohan lee Created on 1/23/24. <br/>
 * 자연수 n이 매개변수로 주어집니다.  <br/>
 * n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요. <br/>
 * 답이 항상 존재함은 증명될 수 있습니다.
 **/
public class L1_나머지가_1이_되는_수_찾기 {
    public static void main(String[] args) {
        L1_나머지가_1이_되는_수_찾기 program = new L1_나머지가_1이_되는_수_찾기();
        System.out.println(program.solution(10));
        System.out.println(program.solution(12));
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i < n; i++) {
            if(n%i == 1) {
                return i;
            }
        }
        return answer;
    }


}
