package algorithm.dynamic;

import java.util.Arrays;

/**
 *
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 * https://leetcode-cn.com/problems/house-robber-ii/
 * @author liq
 * @date 2021/3/4
 */
public class Demo213 {


    public int rob(int[] nums) {


        int length = nums.length;
        if(length == 1) {
            return nums[0];
        }
        int[] copyOfRange = Arrays.copyOfRange(nums, 0, length - 1);
        int[] ints = Arrays.copyOfRange(nums, 1, length);

        return Math.max(ros(copyOfRange),ros(ints));
    }

    private int ros(int[] ints) {

        int n = ints.length;
        if(n == 0) {
            return 0;
        }
        if(n == 1){
            return ints[0];
        }
        int[] dp = new int[n];
        dp[0] = ints[0];
        dp[1] = Math.max(dp[0],ints[1]);
        for (int i = 2; i < ints.length; i++) {
            dp[i] = Math.max(ints[i] + dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new Demo213().rob(nums));
    }


}
