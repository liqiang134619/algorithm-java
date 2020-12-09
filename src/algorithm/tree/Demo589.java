package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liq
 * @date 2020-12-9
 */
public class Demo589 {


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };




    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        return list;

    }

    private void dfs(Node root,List<Integer> list) {
        if(root != null) {
            list.add(root.val);
            if(root.children != null) {
                List<Node> children = root.children;
                for (Node child : children) {
                    dfs(child,list);
                }
            }
        }

    }
}
