package algorithm.tree;


import javax.xml.soap.Node;
import java.util.*;

/**
 * @author Liq
 * @date 2020-11-23
 */
public class Traversal {


    int[] postOrder;
    int postIndex;
    int[] inOrder;

    private Map<Integer,Integer> indexMap;

    // 先序和中序构造二叉树
    public TreeNode buildTree2(int[] preorder, int[] inOrder) {
        this.indexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            indexMap.put(inOrder[i],i);
        }
        return helper2(preorder,0,preorder.length -1,0,inOrder.length -1);
    }

    /**
     *
     * @param preOrder
     * @param preLeft 前序中左子树的起始点
     * @param preRight 前序中右子树的起始点
     * @param inLeft 中序左子树起始点
     * @param inRight 中序右子树起始点
     * @return
     */
    private TreeNode helper2(int[] preOrder, int preLeft, int preRight, int inLeft, int inRight) {
        if(preLeft > preRight || inLeft > inRight) {
            return null;
        }
        // 前序第一个节点为根
        int rootVal = preOrder[preLeft];
        TreeNode treeNode = new TreeNode(rootVal);
        int pIndex = indexMap.get(rootVal);

        treeNode.left = helper2(preOrder,preLeft+1,pIndex-inLeft + preLeft,
                inLeft,pIndex -1);
        treeNode.right = helper2(preOrder,pIndex-inLeft + preLeft + 1,preRight,
                pIndex + 1,inRight);
        return treeNode;

    }


    // 中序和后序构造二叉树
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postOrder = postorder;
        this.inOrder = inorder;
        postIndex = postOrder.length - 1;

        return helper(0,inorder.length -1);
    }

    public TreeNode helper(int left,int right) {
        if(left > right) {
            return null;
        }
        // 构造的后序中的节点值
        int rootVal = postOrder[postIndex];
        postIndex--;

        // 构造根节点
        TreeNode treeNode = new TreeNode(rootVal);

        // 查询出此节点在中序的位置
        int j= 0;
        for (int i = 0; i < inOrder.length; i++) {
            if(inOrder[i] == treeNode.val) {
                j = i;
                break;
            }
        }

        treeNode.right = helper(j+1,right);
        treeNode.left = helper(left,j-1);

        return treeNode;
    }






    // 先序递归
    // 12485367
    private void preOrderTraversal(TreeNode node) {
        if(node == null) {
         return;
        }
        System.out.println(node.val);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
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

    // 中序遍历非递归
    private void  inOrderTraversal(TreeNode node) {
        if(node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || node != null) {
            while(node !=null ){
                stack.push(node);
                node = node.left;
            }
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            node = pop.right;
        }
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

    // 层次遍历
    private void levelOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
           int size = queue.size();
           while (size > 0) {
               TreeNode poll = queue.poll();
               System.out.println(poll.val);
               if(poll.left != null) {
                   queue.offer(poll.left);
               }
               if(poll.right != null) {
                   queue.offer(poll.right);
               }
               size--;
           }
        }

    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> sub = new ArrayList<>();
            while(size > 0) {
                TreeNode poll = queue.poll();
                sub.add(poll.val);
                if(poll.left != null) {
                    queue.offer(poll.left);
                }
                if(poll.right != null) {
                    queue.offer(poll.right);
                }
                size--;
            }
            lists.add(sub);
        }
        return lists;

    }




    // 递归求高度.类似后续遍历；自低向上
    public int maxDept1(TreeNode root) {

        if(root == null) {
            return 0;
        } else  {
            int leftH = maxDept1(root.left);
            int rightH = maxDept1(root.right);
            return Math.max(leftH,rightH) + 1;
        }
    }


    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode root, TreeNode root1) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root1);

        while(!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null) {
                continue;
            }
            if((left == null || right == null ) || (right.val != left.val)) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);

        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        TreeNode treeNode = TreeNode.createTreeNode(nums, 0);

        Traversal preTraversal = new Traversal();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(12);
        queue.offer(11);
        queue.offer(13);
        queue.offer(null);
        queue.offer(14);
        int size = queue.size();
        while(size > 0) {
            System.out.println(queue.poll());
            size --;
        }


    }
}
