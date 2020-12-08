package algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *
 * @author liq
 * @date 2020/12/7
 */
public class Demo637 {


    // 层次遍历呗
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int i = size;
            double sum = 0;
            while (size > 0) {
                TreeNode poll = queue.poll();
                if(poll != null) {
                    sum += poll.val;
                }
                if(poll.left !=null) {
                    queue.offer(poll.left);
                }
                if(poll.right !=null) {
                    queue.offer(poll.right);
                }

                size--;
            }
            list.add(sum / i);

        }
        return list;

    }


    public static void main(String[] args) {


    }
}
