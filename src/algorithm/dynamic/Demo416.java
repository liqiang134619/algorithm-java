package algorithm.dynamic;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * <p>
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * <p>
 * 输入: [1, 5, 11, 5]
 * <p>
 * 输出: true
 * <p>
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1, 2, 3, 5]
 * <p>
 * 输出: false
 * <p>
 * 解释: 数组不能分割成两个元素和相等的子集.
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 *
 * @author Liq
 * @date 2021/3/18
 */
public class Demo416 {


    // 动态规划 背包问题
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;


        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // 容量为0 默认可以装入
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装入或者不装入
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }

            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        Demo416 demo416 = new Demo416();
        boolean b = demo416.canPartition(new int[]{1, 2, 3, 5});
        System.out.println(b);
    }


    // 动态规划 背包问题
    public boolean canPartition2(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;

        int n = nums.length;
        boolean[] dp = new boolean[target + 1];

        // 容量为0 默认可以装入
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = target; j > 0 ; j--) {
                if(j < nums[i-1]) {
                    dp[j] = dp[j-1];
                } else {
                    dp[j] = dp[j] || dp[j-nums[i-1]];
                }
            }

        }

        return dp[target];
    }

}




























