package algorithm.dynamic;

/**
 *
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * 不限次交易,求最大的收益
 * @author liq
 * @date 2021/2/27
 */
public class Demo122 {




    // 贪心算法
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length -1 ; i++) {
            if(prices[i+1] > prices[i]){
                total += (prices[i+1] - prices[i]);
            }
        }
        return total;
    }




    // 动态规划
    public int maxProfit2(int[] prices) {

        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {

            // 未持有    昨天未持有：昨天持有然后卖出
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);

            // 持有  昨天持有：昨天未持有然后买入 对比Demo121 只允许交易一次的话此处dp[i-1][0] 未持有股票收益固定为0
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]- prices[i]);
        }

        // 未持有的最大收益
        return dp[n-1][0];

    }

    // 状态压缩

    public int maxProfit3(int[] prices) {

        int n = prices.length;

        int s1 = 0;
        int s2 = Integer.MIN_VALUE;

        for (int price : prices) {
            int temp = s1;
            s1 = Math.max(s1,s2 + price);
            s2 = Math.max(s2,temp - price);
        }

        return s1;


    }



}



