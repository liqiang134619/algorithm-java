package algorithm.dynamic;


import java.util.Arrays;

/**
 *
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * @author liq
 * @date 2021/3/7
 */
public class Demo1143 {

    int mem[][];

    public int longestCommonSubsequence(String text1, String text2) {

        mem = new int[text1.length()][text2.length()];
        for (int[] ints : mem) {
            Arrays.fill(ints,-1);
        }
        return dp(text1,0,text2,0);
    }

    private int dp(String text1, int i, String text2, int j) {
        if(i == text1.length() || j == text2.length()) {
            return 0;
        }

        if(mem[i][j] != -1) {
            return mem[i][j];
        }
        // 相等
        if(text1.charAt(i) == text2.charAt(j)) {
            mem[i][j] =  1 + dp(text1,i+1,text2,j+1);
        } else {
            mem[i][j] =  Math.max(dp(text1,i+1,text2,j),dp(text1,i,text2,j+1));
        }

        return mem[i][j];
    }

    // 动态规划
    // 从上到下 从左到右
    public int longestCommonSubsequence2(String text1, String text2) {

      // 定义dp数据  dp[m][n]  = 最长公共序列
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
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



}
