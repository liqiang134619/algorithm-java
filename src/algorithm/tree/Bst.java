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





    public Bst(){

    }


    /**
     * 二叉搜索树搜索指定节点
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        if(val < root.val) {
            return searchBST(root.left,val);
        }
        return searchBST(root.right,val);
    }













    Stack<TreeNode> stack = new Stack<>();

    /**
     * 二叉搜索树迭代器： 二叉树中序遍历性质
     * @param root
     */
    public Bst(TreeNode root) {
        helper(root);

    }

    private void helper(TreeNode node) {
        while(node !=null) {
            stack.push(node);
            node = node.left;
        }

    }

    /** @return the next smallest number */
    public int next() {
        TreeNode pop = stack.pop();
        if(pop.right!=null) {
            helper(pop.right);
        }
        return pop.val;

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() > 0;
    }

    private void levelOrder(TreeNode node,List<Integer> list) {
        if(node == null) {
            return;
        }
        levelOrder(node.left,list);
        list.add(node.val);
        levelOrder(node.right,list);
    }




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
     * 二叉搜索树中序遍历后的性质
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
