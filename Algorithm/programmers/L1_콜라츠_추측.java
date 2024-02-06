package programmers;

/**
 * Created by Yohan lee Created on 2/6/24.
 **/
public class L1_콜라츠_추측 {

    public static void main(String[] args) {
        L1_콜라츠_추측 program = new L1_콜라츠_추측();
        System.out.println(program.solution(6));
        System.out.println(program.solution(16));
        System.out.println(program.solution(626331));
    }

    public int solution(int num) {
        long numL = num;
        if (numL == 1) {
            return 0;
        }
        int cnt = 500;
        while (cnt != 0) {
            if (numL % 2 == 0) {
                numL = numL / 2;
            } else {
                numL = numL * 3 + 1;
            }
            cnt--;
            if(numL == 1) {
                return 500 - cnt;
            }
        }
        return -1;
    }
}
