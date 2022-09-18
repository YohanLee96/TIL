package personal;

import java.util.Arrays;

/**
 * Created by Yohan lee Created on 2022/09/16.
 **/
public class 배열이동 {

    public int[] bestSolution(int[]arr, int k) {
        int[] result = new int[arr.length];
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            result[(i+k) % length] = arr[i];
        }
        return result;
    }

    public int[] solution(int[] arr, int k) {
        int[] result = new int[arr.length];
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int index = 0;
            if(length -1 < i + k) {
                index = i + k - length;
            } else {
                index = i + k;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,3,9,7};
        int k = 3;
        배열이동 main = new 배열이동();
        System.out.println(Arrays.toString(main.solution(arr, k)));;
    }
}
