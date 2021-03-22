package algorithm.dynamic;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.time.chrono.MinguoChronology;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Liq
 * @date 2021/3/16
 */
public class Demo279 {


    HashMap<Integer,Integer> map = new HashMap<>();
    // 暴力求解
    public int numSquares(int n) {

        if(map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int res1 = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int sum = numSquares(n - i * i) + 1;
            res1 = Math.min(res1, sum);
        }
        map.put(n,res1);
        return res1;
    }


    // 动态规划
    public int numSquares2(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i],dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }











    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        System.out.println(a / 2.5);
        System.out.println(a/b);
        System.out.println(a ^ b);
        a += b--;
        System.out.println(a++);

    }
}



















