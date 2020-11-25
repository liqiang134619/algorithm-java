package algorithm.tree;

import java.util.*;
import java.util.logging.Level;

/**
 * 二叉树相关题目
 * @author Liq
 * @date 2020-11-25
 */
public class Bt {







    Map<Integer,TreeNode> nodeMap = new HashMap<>();
    Set<Integer> nodeSet = new HashSet<>();
    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
       dfs(root);
       while(p !=null) {

           nodeSet.add(p.val);
           // 父节点

           p = nodeMap.get(p.val);
       }
       while( q != null) {

           if(nodeSet.contains(q.val)) {
               return q;
           }
           q = nodeMap.get(q.val);
       }
       return null;

    }

    private void dfs(TreeNode root) {
        if(root.left != null) {
            nodeMap.put(root.left.val,root);
            dfs(root.left);
        }
        if(root.right != null) {
            nodeMap.put(root.right.val,root);
            dfs(root.right);
        }
    }




    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //1.左右为空直接返回null
        if(left == null && right == null) {
            return null;
        }

        // 3、左边为空 q p都在右子树 返回右子树
        if(left == null) {
            return right;
        }

        // 4.同3
        if(right == null) {
            return left;
        }
        // 2. if(left != null and right != null) 左右两边找到了
        return root;
    }


    /**
     * 根节点到某一个节点的路径不含最终值
     * @param root 根节点
     * @param node 目标节点
     * @param list 保存的结果值
     */
    public void getPathFromRoot(TreeNode root, TreeNode node, List<TreeNode> list) {

        if(root == null || node == null) {
            return;
        }
        list.add(root);
        if(root.val == node.val) {
            return;
        }
        if(root.left !=null ){

        }
    }


    /**
     * 根节点到叶子节点的目标和
     * 示例: 
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }

        // 叶子节点
        if(root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }



    /**
     * 判断一个二叉树是否是镜像对称的
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {

        // 初始时执行同一个树根,随后各自向子树移动: 有root1.left = root2.right;root1.right = root2.left
        return check(root,root);
    }


    private boolean check(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        // 左右子树有个不为空
        if(left ==null || right == null) {
            return false;
        }
        return left.val == right.val&& check(left.left,right.right) && check(left.right,right.left);
    }


    /**
     * 二叉树的最大深度
     * 递归求二叉树的高度：知道左右子树的高度，取子树最大者+1 便是根的高度（深度）
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))  + 1;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};

        TreeNode treeNode = TreeNode.createTreeNode(nums, 0);
        Bt bt = new Bt();
        int i = bt.maxDepth(treeNode);
        System.out.println(i);

    }
}
