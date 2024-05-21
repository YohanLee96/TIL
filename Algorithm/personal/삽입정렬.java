package personal;

import java.util.Random;

/**
 * Created by Yohan Lee. Created on 2024-04-30 <br/>
 **/
public class 삽입정렬 {

    private static final int[] nums = new Random().ints(100, 0, 100)
                                                  .toArray();


    public static void main(String[] args) {
        //삽입정렬
        System.out.println(System.nanoTime());
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
        System.out.println(System.nanoTime());
    }
}
