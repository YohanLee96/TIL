package personal;

import java.util.Random;

/**
 * Created by Yohan Lee. Created on 2024-04-30 <br/>
 **/
public class 선택정렬 {

    //랜덤 정수 100개
    private static final int[] nums = new Random().ints(100, 0, 100)
                                                  .toArray();

    public static void main(String[] args) {
        //선택정렬
        System.out.println(System.nanoTime());
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        System.out.println(System.nanoTime());
    }
}
