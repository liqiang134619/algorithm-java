package algorithm.leetcode;

import java.util.*;

/**
 *
 * 645. 错误的集合
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 * 注意:
 *
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 *
 * @author liq
 * @date 2020/6/25
 */
public class Demo645 {

    public static void main(String[] args) {

        int[] nums = {1,2,2,4};
        System.out.println(Arrays.toString(findErrorNums(nums)));

    }

    private static int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        int num1 = -1;
        int num2 = -1;
        for (int num : nums) {
            if (set.contains(num)) {
                num1 = num;
            }
            set.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(i)) {
                num2 = i;
            }
        }
        return new int[]{num1,num2};



    }

    public char firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.get(c) == 1) {
                return c;
            }
        }
        return ' ';


    }
}
