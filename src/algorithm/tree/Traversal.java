package algorithm.tree;


import java.util.Stack;

/**
 * @author Liq
 * @date 2020-11-23
 */
public class Traversal {


    // 先序递归
    // 12485367
    private void preorderTraversal(TreeNode node) {
        if(node == null) {
         return;
        }
        System.out.println(node.val);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }


    // 先序非递归: 右边入栈然后左边入栈
    private void preOderTraversal2(TreeNode node) {
        if(node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            if(pop.right!=null) {
                stack.push(pop.right);
            }
            if(pop.left !=null) {
                stack.push(pop.left);
            }
        }
    }


    // 先序非递归: 把左子树连续入栈
    private void preOderTraversal3(TreeNode node) {
        if(node ==null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || node != null) {

            while (node!=null) {
                System.out.println(node.val);
                stack.push(node);
                node = node.left;
            }
            TreeNode pop = stack.pop();
            node = pop.right;
        }

    }





    // 中序
    // 84251637
    private void inorderTraversal(TreeNode node) {
        if(node ==null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.println(node.val);
        inorderTraversal(node.right);
    }

    // 后序
    // 84526731
    public void postorderTraversal(TreeNode node) {
        if(node ==null) {
            return;
        }
        inorderTraversal(node.left);
        inorderTraversal(node.right);
        System.out.println(node.val);
    }







    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        TreeNode treeNode = TreeNode.createTreeNode(nums, 0);

        Traversal preTraversal = new Traversal();
        preTraversal.preOderTraversal2(treeNode);


    }
}
