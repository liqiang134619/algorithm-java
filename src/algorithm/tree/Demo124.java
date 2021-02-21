package algorithm.tree;

/**
 *
 * 124. 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liq
 * @date 2021/2/20
 */
public class Demo124 {
    int res = 0;

    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    private Integer dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftValue = Math.max(0,dfs(root.left));
        int rightValue = Math.max(0,dfs(root.right));
        res = Math.max(res,leftValue + rightValue + root.val);
        return Math.max(leftValue,rightValue) + root.val;
    }
}
