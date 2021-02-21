package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liq
 * @date 2021/2/14
 */
public class Demo1022 {


    Integer count = 0;


    public int sumRootToLeaf(TreeNode root) {
        helper(root,0);
        return count;

    }

    private void helper(TreeNode root, Integer level) {
        if(root != null) {
            int num = 1<<level;
            count +=num;
            helper(root.left,level + 1 );
            helper(root.right,level + 1 );

        }
    }

    public static void main(String[] args) {
        System.out.println(1<<3);
    }


}
