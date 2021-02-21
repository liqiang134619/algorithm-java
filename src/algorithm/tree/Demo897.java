package algorithm.tree;

/**
 * @author liq
 * @date 2021/2/14
 */
public class Demo897 {

    TreeNode cur;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode node = new TreeNode(0);
        cur = node;
        helper(root);
        return node.right;
    }

    public void helper(TreeNode node) {
        if(node == null) {
            return;
        }
        helper(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        helper(node.right);
    }
}
