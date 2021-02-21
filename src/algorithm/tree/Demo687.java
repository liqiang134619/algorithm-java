package algorithm.tree;

/**
 * 687. 最长同值路径
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-univalue-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liq
 * @date 2021/2/20
 */
public class Demo687 {

    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    private Integer dfs(TreeNode root) {
        if(root.left == null && root.right == null) {
            return 0;
        }

        int left = root.left == null ? 0:dfs(root.left) + 1;
        int right = root.right == null ? 0:dfs(root.right) + 1;
        if(root.left!=null && root.left.val != root.val) {
            left = 0;
        }
        if(root.right!=null && root.right.val != root.val) {
            right = 0;
        }
        res = Math.max(res,left+right);
        return Math.max(left,right);

    }
}
