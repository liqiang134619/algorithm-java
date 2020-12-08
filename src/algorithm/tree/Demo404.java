package algorithm.tree;

import java.util.Stack;

/**
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * @author liq
 * @date 2020/11/28
 */
public class Demo404 {



    // 深度优先搜索
    public int sumOfLeftLeaves2(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return dfs(root);

    }

    private int dfs(TreeNode root) {
        int sum = 0;
        if( root.left != null) {

            // 叶子节点
            if(root.left.left ==null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum +=dfs(root.left);
            }
        }
        if(root.right !=null) {
            if(!(root.right.left == null && root.right.right == null)) {
                sum += dfs(root.right);
            }
        }

        return sum;
    }

    public int sumOfLeftLeaves(TreeNode root) {

        if(root ==null) {
            return 0;
        }
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            int i = 0;
            TreeNode node = root;
            while (root!=null) {
                i++;
                node = root;
                stack.push(root);
                root = root.left;
            }
            if(node != null && node.right == null && i > 1) {
                sum += node.val;
            }

            TreeNode pop = stack.pop();
            root = pop.right;
        }
        return sum;

    }

    public static void main(String[] args) {

    }
}
