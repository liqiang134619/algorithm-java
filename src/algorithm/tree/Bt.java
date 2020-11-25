package algorithm.tree;

/**
 * 二叉树相关题目
 * @author Liq
 * @date 2020-11-25
 */
public class Bt {


    /**
     * 二叉树的最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))  + 1;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};

        TreeNode treeNode = TreeNode.createTreeNode(nums, 0);


    }
}
