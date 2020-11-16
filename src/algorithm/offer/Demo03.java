package algorithm.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 *
 * 剑指offer03
 * @author liq
 * @date 2020/6/26
 */
public class Demo03 {

    public static void main(String[] args) {

        int[] nums = {2,3,1,0,2,5,3};

        System.out.println(findRepeatNumber(nums));

    }

    private static int findRepeatNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > 1) {
                return num;
            }
        }

        return -1;
    }
    private static int findRepeatNumber1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }


}
