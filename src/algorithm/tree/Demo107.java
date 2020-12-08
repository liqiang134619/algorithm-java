package algorithm.tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 二叉树的层次遍历
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * @author liq
 * @date 2020/11/28
 */
public class Demo107 {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> lists = new LinkedList<>();
        if(root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while(size > 0) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left !=null) {
                    queue.offer(poll.left);
                }
                if(poll.right != null) {
                    queue.offer(poll.right);
                }
                size--;
            }
            lists.add(0,list);
        }

        return lists;
    }




    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode treeNode = TreeNode.createTreeNode(nums, 0);
        Demo107 demo107 = new Demo107();
        List<List<Integer>> lists = demo107.levelOrderBottom(treeNode);
        System.out.println(lists);
    }
}
