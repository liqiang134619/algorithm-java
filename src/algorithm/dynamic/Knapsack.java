package algorithm.dynamic;

/**
 *有 N 个物品和容量为 W 的背包，每个物品都有
 * 自己的体积 w 和价值 v，求拿哪些物品可以使得背包所装下物品的总价值最大。如果限定每种物
 * 品只能选择 0 个或 1 个，则问题称为 0-1 背包问题；如果不限定每种物品的数量，则问题称为无 界背包问题或完全背包问题。
 * 背包问题
 * @author Liq
 * @date 2021/3/17
 */

public class Knapsack {


    /**
     * 0-1背包
     * @param wight 物品重量
     * @param values 物品价值
     * @param n 物品数量
     * @param w 背包容量
     * @return 寻求背包可容纳的最大价值
     */
    public int demo01(int[] wight,int[] values , int n, int w) {

        // 定义dp数组 确定转移， dp[i][j] 表示前i个物品在背包容量j下的最大价值 
        //  不装入：dp[i][j] = dp[i-1][j] ，装入：dp[i][j] = dp[i-1][j-W] + V ， w:当前装入物品的重量， v当前装入物品的价值
        
        int[][] dp = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) {
            // 第i物品的在重量和价值
            int ww = wight[i-1];
            int vv = values[i-1];
            for (int j = 1; j <= w ; j++) {
                if(j >= ww) {
                    //  不装入和 装入的最大者
                    // dp[i-1][j-w] + vv ： [j-ww] 剩余重量下的最大价值 逐层转移而来
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-ww] + vv);
                } else {
                    // 直接装不下
                    dp[i][j] = dp[i-1][j];
                }
            }
            
        }

        return dp[n][w];
        
    }



    /**
     * 0-1背包 状态压缩
     * @param wight 物品重量
     * @param values 物品价值
     * @param n 物品数量
     * @param w 背包容量
     * @return 寻求背包可容纳的最大价值
     */
    public int demo02(int[] wight,int[] values , int n, int w) {

        // 定义dp数组 确定转移， dp[i][j] 表示前i个物品在背包容量j下的最大价值
        //  不装入：dp[i][j] = dp[i-1][j] ，装入：dp[i][j] = dp[i-1][j-W] + V ， w:当前装入物品的重量， v当前装入物品的价值

        int[] dp = new int[w+1];

        for (int i = 1; i <= n; i++) {
            // 第i物品的在重量和价值
            int ww = wight[i-1];
            int vv = values[i-1];
            for (int j = w; j >=0 ; j--) {
                if(j >=ww) {
                    dp[j] = Math.max(dp[j],dp[j-ww] + vv);
                }
            }

        }

        return dp[w];

    }
}
