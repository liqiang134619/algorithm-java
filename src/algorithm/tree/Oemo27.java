package algorithm.tree;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * @author Liq
 * @date 2020-12-3
 */
public class Oemo27 {


    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }


}
