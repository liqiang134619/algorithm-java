package algorithm;

import java.util.Arrays;

/**
 *
 * 定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 *
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个
 *
 * 输入：
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * @author Liq
 * @date 2020/6/19
 */
public class Demo04 {

    public static void main(String[] args) {

        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex1(nums));

    }

    private static  int pivotIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < i; j++) {
                sum1+=nums[j];
            }
            for (int j = i+1,size = nums.length; j < size; j++) {
                sum2+=nums[j];
            }
            if(sum1 == sum2) {
                return i;
            }
        }
        return -1;

    }

    private static int pivotIndex1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum - nums[i] - leftSum == leftSum) {
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }
}
