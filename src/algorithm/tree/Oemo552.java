package algorithm.tree;

/**
 * @author Liq
 * @date 2020-12-4
 */
public class Oemo552 {


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
