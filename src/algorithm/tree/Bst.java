package algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索数相关
 * @author Liq
 * @date 2020-11-25
 */
public class Bst {



    /**
     * 判定一个树是否是bst 解法2
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root){
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return helper2(root,min,max);
    }

    private boolean helper2(TreeNode root, Integer min, Integer max) {
        if(root == null) {
            return true;
        }
        int val = root.val;
        if (min != null && val <= min) {
            return false;
        }
        if (max != null && val >= max) {
            return false;
        }
        if(!helper2(root.left,min,root.val)) {
            return false;
        }
        if(!helper2(root.right,root.val,max)) {
            return false;
        }
        return true;
    }


    /**
     * 判定一个树是否是bst
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        double val = -Double.MAX_VALUE ;
        if(root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || root != null) {
            while(root !=null ){
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if(pop.val <= val) {
                return false;
            }
            val = pop.val;
            root = pop.right;
        }

        return true;
    }
































    public static void main(String[] args) {

        int[] nums = {1,1};
        TreeNode treeNode = TreeNode.createTreeNode(nums, 0);

        Bst bst = new Bst();
        boolean validBST2 = bst.isValidBST2(treeNode);
        System.out.println(validBST2);

    }
}
