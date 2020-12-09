package algorithm.tree;

/**
 * 二叉树展开为一个链表
 * @author Liq
 * @date 2020-11-27
 */
public class Demo114 {





    public TreeNode convertBiNode(TreeNode root) {
        TreeNode head = new TreeNode(0);// 单链表的头指针哨兵
        // 开始中序遍历
        inorder(root,head);
        return head.right;
    }

    private TreeNode inorder(TreeNode root,TreeNode prev){
        if (root != null){
            prev = inorder(root.left,prev);
            root.left = null;
            prev.right = root;
            prev = root;
            prev = inorder(root.right,prev);
        }
        return prev;
    }





    /**
     * 相信递归定义，不要钻入细节
     * @param root
     */
    public void flatten(TreeNode root) {
        if(root ==null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;


        // 左子树置空
        root.left = null;

        // 原来的左子树放到右子树
        root.right = left;

        // 原来的右子树放到左树下面
        TreeNode node = root;

        while(root !=null) {
            node = root;
            root = root.right;
        }

        node.right = right;

    }
}
