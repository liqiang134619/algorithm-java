package algorithm.dynamic;

/**
 *
 * 583. 两个字符串的删除操作
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *
 *
 *
 * 示例：
 *
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 *
 *
 * 提示：
 *
 * 给定单词的长度不超过500。
 * 给定单词中的字符只含有小写字母。
 * https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 * @author Liq
 * @date 2021/3/10
 */
public class Demo583 {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int subsequence = longestCommonSubsequence(word1, word2);

        return m - subsequence + n - subsequence;

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



}































