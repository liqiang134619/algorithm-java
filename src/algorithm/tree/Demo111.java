package algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 * @author liq
 * @date 2020/11/28
 */
public class Demo111 {


    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;


        if(root.left !=null) {
            min = Math.min(minDepth(root.left),min);
        }
        if(root.right !=null) {
            min = Math.min(minDepth(root.right),min);
        }
        return min + 1;
    }

    public int minDepth2(TreeNode root) {

        if(root == null) {
            return 0;
        }
        int dept = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll.left == null && poll.right == null) {
                    return dept;
                }
                if(poll.left != null) {
                    queue.offer(poll.left);
                }
                if(poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            dept++;
        }

        return dept;
    }
}
