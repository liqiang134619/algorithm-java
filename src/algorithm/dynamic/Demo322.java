package algorithm.dynamic;


import java.util.Arrays;
import java.util.HashMap;

/**
 * 找零钱
 * @author liq
 * @date 2021/2/18
 */
public class Demo322 {


    HashMap<Integer,Integer> hashMap = new HashMap<>();


    public int coinChange(int[] coins, int amount) {

        if(hashMap.containsKey(amount)) {
            return hashMap.get(amount);
        }

        if(amount == 0) {
            return  0;
        }
        if(amount < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = coinChange(coins, amount - coin);
            if(sub < 0) {
                continue;
            }
            res = Math.min(res, 1+sub);
        }
        int num = res == Integer.MAX_VALUE?-1:res;
        hashMap.put(amount,num);
        return num;
    }


    public int coinChange2(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount+1);
        // base case
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if(i-coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i],dp[i-coin] + 1);
            }
        }

        return dp[amount] == amount+1 ? -1:dp[amount];
    }


}
