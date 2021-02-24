package algorithm.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * https://leetcode-cn.com/problems/permutations/
 * @author Liq
 * @date 2021/2/23
 */
public class Demo46 {



    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {

        LinkedList<Integer> sub = new LinkedList<>();

        dfs(nums,sub);

        return res;

    }

    private void dfs(int[] nums, LinkedList<Integer> sub) {

        if(sub.size() == nums.length) {
            res.add(new LinkedList<>(sub));
            return;
        }

        for (int num : nums) {
            if (sub.contains(num)) {
                continue;
            }
            // 做出决策
            sub.add(num);
            // 进入下层
            dfs(nums, sub);
            // 回溯
            sub.removeLast();

        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        List<List<Integer>> permute = new Demo46().permute(nums);
        System.out.println(permute);
    }


}








































