package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liq
 * @date 2021/2/14
 */
public class Demo965 {

    List<Integer> list = new ArrayList<>();


    public boolean isUnivalTree(TreeNode root) {

        dfs(root);
        Integer integer1 = list.get(0);
        for (Integer integer : list) {
            if(!integer.equals(integer1)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode root) {
        if(root != null) {
            list.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
    }


}
