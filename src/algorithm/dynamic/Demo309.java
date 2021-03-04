package algorithm.dynamic;

/**
 *
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * @author liq
 * @date 2021/2/28
 */
public class Demo309 {



    // 动态规划，三个状态的转移
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if(n <= 0) {
            return 0;
        }
        int[][] dp = new int[n][3];

        // 初始状态
        // 未持有股票
        dp[0][0] = 0;

        // 持有股票
        dp[0][1] = -prices[0];

        // 没有股票，不可交易
        dp[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {

            // 未持有股票从  上一天未持有 和  卖出进入冷冻期 而 转移
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]);


            // 持有股票  上一天已经持有  和 未持有然后购买而转移
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);

            // 冷冻期未持有股票
            dp[i][2] = dp[i-1][1] + prices[i];

        }

        return Math.max(dp[n-1][0],dp[n-1][2]);

    }





    // 动态规划，2个状态的转移
    public int maxProfit2(int[] prices) {
        int n = prices.length;

        if(n <= 0) {
            return 0;
        }
        int[][] dp = new int[n][2];

        // 初始状态
        // 未持有股票
        dp[0][0] = 0;

        // 持有股票
        dp[0][1] = -prices[0];

        dp[1][0] = Math.max(dp[0][0],dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1],-prices[1]);

        for (int i = 2; i < prices.length; i++) {

            // 未持有股票从  上一天未持有 和  上一天持有股票然后今天卖出 而 转移
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);

            // 持有股票  上一天已经持有  和  买入今天的股票
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0] - prices[i]);


        }

        return dp[n-1][0];

    }
}
