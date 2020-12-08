package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liq
 * @date 2020-12-8
 */
public class Demo501 {

    List<Integer> list = new ArrayList<>();
    int count;
    int base;
    int maxCount;
    public int[] findMode(TreeNode root) {

        dfs(root);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;

    }

    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        if(root.val == base) {
            count ++;
        } else {
            count = 1;
            base = root.val;
        }
        if(count == maxCount) {
            list.add(root.val);
        }
        if(count > maxCount) {
            list.clear();
            list.add(root.val);
        }

        dfs(root.right);
    }
}
