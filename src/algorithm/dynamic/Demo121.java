package algorithm.dynamic;

/**
 *
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 *  只能交易一次
 * @author liq
 * @date 2021/2/26
 */
public class Demo121 {


    /**
     *  0 < x < prices.len
     *
     *  x < y < price.len
     *
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int res = 0;

        for (int buy = 0; buy < prices.length; buy++) {
            for (int sell = buy + 1; sell < prices.length; sell++) {

                res = Math.max(res,prices[sell] - prices[buy]);
            }
        }

        return res;

    }


    public int maxProfit2(int[] prices) {

        int res = 0;

        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min,prices[i]);
            res = Math.max(res,prices[i] - min);
        }

        return res;

    }



    // dp
    public int maxProfit3(int[] prices) {

        int length = prices.length;
        int[][] dp = new int[length][2];

        for (int i = 0; i < length; i++) {

            if(i-1 == -1) {
                //
                // max(dp[-1][0],dp[-1][1] + prices[i])
                // max(0,-infinity + prices[i])
                dp[i][0] = 0;

                // Math.max(dp[-1][1],dp[-1][0] - prices[i])
                // Math.max(-infinity,0-prices[i])
                dp[i][1] = -prices[i];
                continue;
            }
            // 未持有
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);

            // 持有 dp[i-1][0] = 0 :未持有
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }

        return dp[length - 1][0];

    }


    public int maxProfit4(int[] prices) {

        int s = 0;
        int s1 = Integer.MIN_VALUE;
        for (int price : prices) {

            // 未持有
            s = Math.max(s, s1 + price);

            // 持有 dp[i0-1][0] = 0 :未持有
            s1 = Math.max(s1, -price);
        }

        return s;

    }


}
