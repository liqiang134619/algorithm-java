package algorithm.tree;

import java.nio.channels.Pipe;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 *
 * @author liq
 * @date 2020/12/10
 */
public class Demo993 {


    public boolean isCousins(TreeNode root, int x, int y) {

        if (root == null) {
            return false;
        }

        Integer xNode = null;
        TreeNode xNodeParent = null;


        Integer yNode = null;
        TreeNode yNodeParent = null;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode poll = queue.poll();

                if (poll.left != null) {
                    if (poll.left.val == x) {
                        xNode = poll.left.val;
                        xNodeParent = poll;
                    }
                    if (poll.left.val == y) {
                        yNode = poll.left.val;
                        yNodeParent = poll;
                    }
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    if (poll.right.val == x) {
                        xNode = poll.right.val;
                        xNodeParent = poll;
                    }
                    if (poll.right.val == y) {
                        yNode = poll.right.val;
                        yNodeParent = poll;
                    }
                    queue.offer(poll.right);
                }
                if (xNode == null && yNode == null) {
                    // nothing
                } else if (xNode != null && yNode != null) {
                    return xNodeParent != yNodeParent;
                }
                else if (size == 0) {
                    return false;
                }

            }

        }

        return false;
    }
}
