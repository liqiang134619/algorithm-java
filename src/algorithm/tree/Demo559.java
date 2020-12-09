package algorithm.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 *
 * @author Liq
 * @date 2020-12-9
 */
public class Demo559 {


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


    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        if(root.children != null) {
            List<Integer> heights = new LinkedList<>();
            for (Node child : root.children) {
                heights.add(maxDepth(root));
            }
            return Collections.max(heights) + 1;
        }
        return 1;

    }
}
