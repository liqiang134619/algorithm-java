package algorithm.other;

/**
 *
 * 在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 * @author Liq
 * @date 2020-11-27
 */
public class Solution {


    /**
     * 解法1， 双层循环 O(n^2)
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = Math.max(i - k, 0); j < i; ++j) {
                if (Math.abs(nums[i] - nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(-2147483648 - 2147483647);
        int abs = Math.abs(-2147483648 - 2147483647);
        System.out.println(abs);
    }








}
