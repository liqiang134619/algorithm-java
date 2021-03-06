package algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点
 *
 * @author Liq
 * @date 2020-12-3
 */
public class Oemo54 {


    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            list.add(pop.val);
            root = pop.right;

        }

        return list.get(list.size() - k);
    }



    int count = 0;
    int res = -1;

    public int kthLargest1(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }
        helper(root,k);
        return res;
    }

    private void helper(TreeNode root, int k) {
        if(root == null) {
            return;
        }
        helper(root.right,k);
        count++;
        if(count == k) {
            res = root.val;
            return;
        }
        helper(root.left,k);
    }
}
