package algorithm.dynamic;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 *
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @author liq
 * @date 2021/3/17
 */
public class Demo300 {


    // 动态规划，定义dp[i] 是以 i结尾的最大子序列
    // 则 对于 i 之前的j 如果有j < i 可以得到一个以i结尾的 长度为dp[j] + 1 的最长子序列
    // 遍历数组两次，复杂度 o(n^2)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 1;
        }

        int maxLength = 0;
        int[]dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }

            // 比较每个位置的最大值
            maxLength = Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }
}










