package algorithm.tree;


import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liq
 * @date 2021/2/21
 */
public class Demo113 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if(root == null) {
            return res;
        }
        path.offerLast(root.val);
        dfs2(root,targetSum - root.val);

        return res;

    }

    private void dfs(TreeNode root, int targetSum) {
        if(root == null) {
            return;
        }
        path.offerLast(root.val);
        if(root.left == null && root.right == null) {
            if(root.val == targetSum) {

                res.add(new LinkedList<Integer>(path));
            }
        }

        // 隐含了回溯
        dfs(root.left,targetSum - root.val);
        dfs(root.right,targetSum - root.val);
        path.pollLast();

    }

    // 明确出回溯
    private void dfs2(TreeNode root, int targetSum) {
        if(root.left == null && root.right == null && targetSum == 0) {
             res.add(new LinkedList<Integer>(path));
             return;
        }

        if(root.left == null && root.right == null) {
            return;
        }


        if(root.left != null) {
            path.offerLast(root.left.val);
            dfs2(root.left,targetSum - root.left.val);
            // 回溯
            path.pollLast();
        }

        if(root.right != null) {
            path.offerLast(root.right.val);
            dfs2(root.right,targetSum - root.right.val);
            // 回溯
            path.pollLast();
        }

    }







    public static void main(String[] args) {
        Demo113 demo113 = new Demo113();
        int[] nums = {1,2,3,4,5,11,7,8,9};
        TreeNode treeNode = TreeNode.createTreeNode(nums, 0);
        List<List<Integer>> lists = demo113.pathSum(treeNode, 15);
        System.out.println(lists);
    }
}
