package algorithm.tree;


/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * @author Liq
 * @date 2020-12-4
 */
public class Oemo28 {



    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return false;
        }
        return helper(root.left,root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        return left.val == right.val && helper(left.left,right.right) && helper(left.right,right.left);

    }
}
