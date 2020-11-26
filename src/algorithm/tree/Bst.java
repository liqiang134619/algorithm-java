package algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索数相关
 * @author Liq
 * @date 2020-11-25
 */
public class Bst {





    public Bst(){

    }


    /**
     * 二叉搜索树删除指定节点
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return root;
        }
        if(key < root.val) {
            root.left =  deleteNode(root.left,key);
        } else if(key > root.val) {
            root.right =  deleteNode(root.right,key);
        } else if(root.left != null && root.right !=null) {
            /*
            // 找到删除的元素了但有左右儿子
            // 找到右子树的最小元素替换删除
            TreeNode node = root.right;
            TreeNode node2 = null;
            while(node != null) {
                node2 = node;
                node = node.left;
            }
            root.val = node2.val;
            root.right = deleteNode(root.right,root.val);*/

            // 直接删除右子树最小元素即可
            TreeNode node = root.right;
            TreeNode node2 = null;
            while(node != null) {
                node2 = node;
                node = node.left;
            }
            root.val = node2.val;
                root = root.right;
                while(root.left !=null) {
                    root = root.left;
                }
                root = null;


        } else {
            root = (root.left != null?root.left:root.right);
        }
        return root;
    }

    /**
     * 二叉搜索搜索树的插入
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root ==null) {
            root = new TreeNode(val);
            return root;
        }
        if(val < root.val) {
            root.left =  insertIntoBST(root.left,val);
        }
        if(val > root.val) {
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }

    /**
     * 二叉搜索树搜索指定节点
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        if(val < root.val) {
            return searchBST(root.left,val);
        }
        return searchBST(root.right,val);
    }


    /**
     * 二叉搜索树搜索指定节点
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST2(TreeNode root, int val) {

        while(root!=null) {
            if(root.val == val) {
                return root;
            } else if(val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return null;
    }












    Stack<TreeNode> stack = new Stack<>();

    /**
     * 二叉搜索树迭代器： 二叉树中序遍历性质
     * @param root
     */
    public Bst(TreeNode root) {
        helper(root);

    }

    private void helper(TreeNode node) {
        while(node !=null) {
            stack.push(node);
            node = node.left;
        }

    }

    /** @return the next smallest number */
    public int next() {
        TreeNode pop = stack.pop();
        if(pop.right!=null) {
            helper(pop.right);
        }
        return pop.val;

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() > 0;
    }

    private void levelOrder(TreeNode node,List<Integer> list) {
        if(node == null) {
            return;
        }
        levelOrder(node.left,list);
        list.add(node.val);
        levelOrder(node.right,list);
    }




    /**
     * 判定一个树是否是bst 解法2
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root){
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return helper2(root,min,max);
    }

    private boolean helper2(TreeNode root, Integer min, Integer max) {
        if(root == null) {
            return true;
        }
        int val = root.val;
        if (min != null && val <= min) {
            return false;
        }
        if (max != null && val >= max) {
            return false;
        }
        if(!helper2(root.left,min,root.val)) {
            return false;
        }
        if(!helper2(root.right,root.val,max)) {
            return false;
        }
        return true;
    }


    /**
     * 判定一个树是否是bst
     * 二叉搜索树中序遍历后的性质
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        double val = -Double.MAX_VALUE ;
        if(root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || root != null) {
            while(root !=null ){
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if(pop.val <= val) {
                return false;
            }
            val = pop.val;
            root = pop.right;
        }

        return true;
    }
































    public static void main(String[] args) {

        int[] nums = {1,1};
        TreeNode treeNode = TreeNode.createTreeNode(nums, 0);

        Bst bst = new Bst();
        boolean validBST2 = bst.isValidBST2(treeNode);
        System.out.println(validBST2);

    }
}
