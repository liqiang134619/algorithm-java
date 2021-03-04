package algorithm.dynamic;

/**
 *
 * 714. 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 示例 1:
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * @author liq
 * @date 2021/2/28
 */
public class Demo714 {


    // 动态规划，每次交易扣除一次手续费
    public int maxProfit(int[] prices, int fee) {

        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }

        return dp[n-1][0];

    }

    // 状态压缩
    public int maxProfit2(int[] prices, int fee) {

        int s1 = 0;
        int s2 = -prices[0];
        int tmp;
        for (int price : prices) {
            tmp = s1;
            s1 = Math.max(s1,s2 + price - fee);
            s2 = Math.max(s2,tmp - price);
        }

        return s1;

    }

    public static void main(String[] args) {
        int[] p =  new int[]{1,3,2,8,4,9};
        Demo714 demo714 = new Demo714();
        int i = demo714.maxProfit2(p, 2);
        System.out.println(i);
    }




}
