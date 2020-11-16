package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 *  
 *
 * @author liq
 * @date 2020/6/25
 */
public class Demo219 {

    public static void main(String[] args) {


    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer ob=map.get(nums[i]);
            if(ob==null){
                map.put(nums[i],i);
            } else {
                if(i-ob<=k) return true;
                else map.put(nums[i],i);
            }
        }
        return false;


    }
}
