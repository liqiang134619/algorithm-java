package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值
 * @author liq
 * @date 2020/12/7
 */
public class Demo530 {










    List<Integer> list = new ArrayList<>();


    // 中序遍历之后再计算
    public int getMinimumDifference(TreeNode root) {


        dfs(root);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int abs = Math.abs(list.get(i) - list.get(j));
                if(abs < min) {
                    min = abs;
                }
            }
        }
        return min;
    }

    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }


}
