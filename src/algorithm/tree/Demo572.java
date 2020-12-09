package algorithm.tree;

/**
 *
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树
 *
 * @author liq
 * @date 2020/12/5
 */
public class Demo572 {



    public boolean isSubtree(TreeNode s, TreeNode t) {

        boolean helper = helper(s, t);
        boolean left = false;
        boolean right = false;
        if(s.left !=null) {
            left = isSubtree(s.left, t);
        }
        if(s.right != null) {
            right = isSubtree(s.right, t);
        }

        return (helper || left || right);
    }

    private boolean helper(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }
        return s.val == t.val && helper(s.left,t.left) && helper(s.right,t.right);
    }


    public static void main(String[] args) {

    }
}
