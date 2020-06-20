package algorithm;

import java.util.Arrays;

/**
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 * @author liq
 * @date 2020/6/20
 */
public class Demo06 {


    public static void main(String[] args) {

        int[] nums = {1,4,3,2,5,6};
        System.out.println(arrayPairSum(nums));
    }

    private static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum+=nums[i];
        }
        return sum;
    }
}
