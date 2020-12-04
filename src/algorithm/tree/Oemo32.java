package algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * @author Liq
 * @date 2020-12-4
 */
public class Oemo32 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();


        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return list;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list1 = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                list1.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                size--;

            }
            list.add(list1);
        }
        return list;
    }
}
