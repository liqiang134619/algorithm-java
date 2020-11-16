package algorithm.leetcode;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * @author Liq
 * @date 2020/6/18
 */
public class Demo03 {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7};
        rotate1(nums,3);
        System.out.println(Arrays.toString(nums));
    }

    private static void rotate(int[] nums, int k) {
        int n = k % nums.length ;

        for (int i = 0; i < n; i++) {
            int tmp = nums[nums.length -1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = tmp;
        }
    }

    private static void rotate1(int[] nums,int k) {
        int[] tmp = new int[nums.length];
        int n = k % nums.length;
        for (int i = 0; i < nums.length; i++) {
            tmp[(n+i) % nums.length]  = nums[i];
        }
        System.arraycopy(tmp, 0, nums, 0, nums.length);
    }
}
