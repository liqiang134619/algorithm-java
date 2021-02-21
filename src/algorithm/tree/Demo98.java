package algorithm.tree;

import algorithm.other.Solution;

/**
 *
 * isValidBST
 * @author liq
 * @date 2021/2/12
 */

public class Demo98 {


    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    private boolean isValidBST(TreeNode root, int minValue, int maxValue) {
        if(root == null) {
            return true;
        }
        if(minValue > root.val || maxValue < root.val) {
            return false;
        }
        return isValidBST(root.left,minValue,root.val) && isValidBST(root.right,root.val,maxValue);
    }
}
