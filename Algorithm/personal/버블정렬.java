package personal;

import java.util.Random;

/**
 * Created by Yohan Lee. Created on 2024-04-30 <br/>
 **/
public class 버블정렬 {

    private static final int[] nums = new Random().ints(100, 0, 100)
                                                  .toArray();

    public static void main(String[] args) {
        //버블정렬
        System.out.println(System.nanoTime());
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        System.out.println(System.nanoTime());
    }
}
