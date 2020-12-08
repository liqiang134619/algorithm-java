package algorithm.tree;

/**
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * @author liq
 * @date 2020/11/28
 */
public class Demo110 {




    public boolean isBalanced(TreeNode root) {

        if(root == null) {
            return true;
        }
        int left = 0;
        int right = 0;
        if(root.left != null) {
            left = helper(root.left);
        }
        if(root.right !=null) {
            right = helper(root.right);
        }

        return Math.abs(right - left) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }

    private int helper(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        return Math.max(left,right) + 1;
    }
}
