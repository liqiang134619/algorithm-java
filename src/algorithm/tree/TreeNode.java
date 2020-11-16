package algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liq
 * @date 2020/11/15
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }


    // 递归求高度
    public int maxDept1(TreeNode root) {
        if(root == null) {
            return 0;
        } else  {
            int leftH = maxDept1(root.left);
            int rightH = maxDept1(root.right);
            return Math.max(leftH,rightH);
        }
    }


    // 广度优先搜索求高度
    public int maxDept(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int dept = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                TreeNode poll = queue.poll();
                if(poll.left != null) {
                    queue.offer(poll.left);
                }
                if(poll.right != null) {
                    queue.offer(poll.right);
                }
                size--;
            }
            dept++;
        }

        return dept;

    }
}
