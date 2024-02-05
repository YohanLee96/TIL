package programmers;

/**
 * Created by Yohan lee Created on 2/6/24.
 **/
public class L1_정수_내림차순으로_배치하기 {

    public static void main(String[] args) {
        L1_정수_내림차순으로_배치하기 program = new L1_정수_내림차순으로_배치하기();
        System.out.println(program.solution(118372));
    }

    public long solution(long n) {
        String str = String.valueOf(n);
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char max = arr[i];
            int maxIdx = i;
            for (int j = i+1; j < arr.length; j++) {
                if(max < arr[j]) {
                    max = arr[j];
                    maxIdx = j;
                }
            }
            char temp = arr[i];
            arr[i] = max;
            arr[maxIdx] = temp;
        }
        return Long.parseLong(String.valueOf(arr));
    }
}
