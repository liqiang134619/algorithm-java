package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * @author Liq
 * @date 2020-12-3
 */
public class Demo257 {



    public List<String> binaryTreePaths(TreeNode root) {

        ArrayList<String> list = new ArrayList<>();

        constructPath(root,"",list);
        return list;

    }

    private void constructPath(TreeNode root, String s, ArrayList<String> list) {
        StringBuilder sb = new StringBuilder(s);
        if(root != null) {
            sb.append(root.val);
            if(root.left == null && root.right == null) {
                list.add(sb.toString());
            } else {
                sb.append("->");
                constructPath(root.left,sb.toString(),list);
                constructPath(root.right,sb.toString(),list);
            }
        }
    }


    public static void main(String[] args) {


    }
}
