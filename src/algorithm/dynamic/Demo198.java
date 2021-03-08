package algorithm.dynamic;

import java.util.Arrays;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 *      https://leetcode-cn.com/problems/house-robber/
 * @author Liq
 * @date 2021/3/4
 */
public class Demo198 {


    int[] mem;

    public int rob(int[] nums) {

        mem = new int[nums.length];
        Arrays.fill(mem,-1);
        return dp(nums,0);

    }

    private int dp(int[] nums, int i) {
        //  最后一间，收益是0
        if(i >= nums.length) {
            return 0;
        }

        if(mem[i] != -1) {
            return mem[i];
        }

        int res =  Math.max(
                // 抢
                nums[i] + dp(nums,i+2),
                // 不抢
                dp(nums,i+1)
        );
        mem[i] = res;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};

        System.out.println(new Demo198().rob(nums));
    }
}






































