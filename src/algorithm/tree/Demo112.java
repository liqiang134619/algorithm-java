package algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 *
 * 112. 路径总和
 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。

 叶子节点 是指没有子节点的节点。



 示例 1：


 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 输出：true
 https://leetcode-cn.com/problems/path-sum/
 * @author liq
 * @date 2021/2/21
 */
public class Demo112 {


    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode poll = queNode.poll();
            int tmp = queVal.poll();
            if(poll.left == null && poll.right == null) {
                if(tmp == sum) {
                    return true;
                }
                continue;
            }
            if(poll.left != null) {
                queNode.offer(poll.left);
                queVal.offer(tmp + poll.left.val);
            }

            if(poll.right != null) {
                queNode.offer(poll.right);
                queVal.offer(tmp + poll.right.val);
            }
        }
        return false;
    }
}
