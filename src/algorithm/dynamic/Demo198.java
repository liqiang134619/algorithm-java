package algorithm.dynamic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 *      https://leetcode-cn.com/problems/house-robber/
 * @author Liq
 * @date 2021/3/4
 */
public class Demo198 {


    int[] mem;

    public int rob(int[] nums) {

        mem = new int[nums.length];
        Arrays.fill(mem,-1);
        return dp(nums,0);

    }

    private int dp(int[] nums, int i) {
        //  最后一间，收益是0
        if(i >= nums.length) {
            return 0;
        }

        if(mem[i] != -1) {
            return mem[i];
        }

        int res =  Math.max(
                // 抢
                nums[i] + dp(nums,i+2),
                // 不抢
                dp(nums,i+1)
        );
        mem[i] = res;
        return res;
    }


    public int longestCommonSubsequence(String text1, String text2) {

        // 定义dp数据  dp[m][n]  = 最长公共序列
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 相等 上一个相同长度的最大值
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    // 较长的一个
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }








    public static void main(String[] args) {

    }
}






































