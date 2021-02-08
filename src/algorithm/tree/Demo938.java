package algorithm.tree;

/**
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和
 * @author Liq
 * @date 2020-12-9
 */
public class Demo938 {

    int sum = 0;

    // 中序遍历，需要遍历所有的节点
//    public int rangeSumBST(TreeNode root, int low, int high) {
//
//        dfs(root,low,high);
//        return sum;
//    }
//
//    private void dfs(TreeNode root, int low, int high) {
//        if(root == null) {
//            return;
//        }
//        dfs(root.left,low,high);
//        if(root.val >= low && root.val <= high) {
//            sum += root.val;
//        }
//        dfs(root.right,low,high);
//
//    }

    private int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }
        // L< root.val < R
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

}
