package algorithm.tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author liq
 * @date 2021/2/12
 */
public class Demo297 {





    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    public void serialize(TreeNode root,StringBuilder sb) {

        if(root == null) {
            sb.append("$").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serialize(root.left,sb);
        serialize(root.right,sb);

    }
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        LinkedList<String> linkedList = new LinkedList<>();
        for (String s : split) {
            linkedList.addLast(s);
        }
        return deserialize(linkedList);
    }

    public TreeNode deserialize(LinkedList<String> data) {

        if(data.isEmpty()) {
            return null;
        }
        String first = data.removeFirst();
        if("$".equals(first)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deserialize(data);
        root.right = deserialize(data);
        return root;
    }
}
