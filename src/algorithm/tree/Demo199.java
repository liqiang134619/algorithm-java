package algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Liq
 * @date 2021/2/20
 */
public class Demo199 {



    public List<Integer> rightSideView(TreeNode root) {


        List<Integer> res = new LinkedList<>();

        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
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
                if(size == 0) {
                    res.add(poll.val);
                }
            }
        }

        return res;

    }


    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView2(TreeNode root) {

        dfs(root,0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if(root == null) {
            return;
        }
        // 每层的第一个数据
        if(depth == res.size()) {
            res.add(root.val);
        }
        depth++;
        // 根右左
        dfs(root.right,depth);
        dfs(root.left,depth);
    }

}














