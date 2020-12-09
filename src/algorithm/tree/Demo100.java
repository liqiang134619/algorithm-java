package algorithm.tree;

/**
 * 相同的树
 *
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 *
 * @author liq
 * @date 2020/11/27
 */
public class Demo100 {


    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null) {
            return true;
        }
        // 有一个不是null
        if(q == null || p == null) {
            return false;
        }

        return (p.val == q.val) && isSameTree(q.left,p.left) && isSameTree(q.right,p.right);
    }


}
