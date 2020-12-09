package algorithm.tree;

import com.sun.tools.hat.internal.model.Root;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * @author liq
 * @date 2020/11/27
 */
public class Demo652 {

    Map<String, Integer> map = new HashMap<>();

    List<TreeNode> list = new LinkedList<>();

    // 后序遍历
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        helper(root);
        return this.list;
    }

    private String helper(TreeNode node) {
        if(node == null) {
            return "#";
        }
        String left = helper(node.left);
        String right = helper(node.right);
        String re = left + "," + right + node.val;
        Integer integer = map.getOrDefault(re,0);
        if(integer == 1) {
            list.add(node);
        }
        map.put(re,integer + 1);
        return re;
    }

}
