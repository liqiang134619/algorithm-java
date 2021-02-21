package algorithm.tree;

import java.util.Arrays;

/**
 *
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * @author liq
 * @date 2021/2/21
 */
public class Demo96 {


    // 递归
    public int numTrees(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        int num = 0;
        for (int i = 0; i < n; i++) {
            num += numTrees(i) * numTrees(n-i-1);
        }
        return num;

    }

    // 备忘录
    public int numTrees2(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,0);
        return helper(n,dp);
    }

    private Integer helper(int n,int[] dp) {
        if(n ==0 || n ==1 ) {
            return 1;
        }
        if(dp[n] > 0) {
            return dp[n];
        }
        int num = 0;
        for (int i = 0; i < n; i++) {
            num += helper(i,dp) * helper(n-i-1,dp);
        }
        dp[n] = num;
        return num;
    }


    // dp数组
    public int numTrees3(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i-1; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }


}
