package algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    TreeNode(int val,TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public static  TreeNode createTreeNode(int[] nums,int index) {

        TreeNode tn = null;
        if(index < nums.length) {
            int val = nums[index];
            tn = new TreeNode(val);
            tn.left = createTreeNode(nums,2*index+1);
            tn.right = createTreeNode(nums,2*index+2);
            return tn;
        }
        return  tn;
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        preorderTraversal2(root,resList);
        return resList;
    }
    private void preorderTraversal2(TreeNode root,List<Integer> list) {
        if(root == null) {
            return;
        }
        list.add(root.val);
        preorderTraversal2(root.left,list);
        preorderTraversal2(root.right,list);
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
