package algorithm.leetcode;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 * @author Liq
 * @date 2020/6/23
 */
public class Demo349 {

    public static void main(String[] args) {


    }

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        set1.retainAll(set);

        int[] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) {
            output[idx++] = s;
        }
        return output;

    }

    public int[] intersection1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        int pre = Integer.MIN_VALUE;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                if (pre != nums1[i]) {
                    pre = nums1[i];
                    list.add(nums1[i]);
                }
                i++;
                j++;

            }
        }

        int[] re = new int[list.size()];
        for (int i1 = 0; i1 < list.size(); i1++) {
            re[i1] = list.get(i1);
        }
        return re;
    }
}
