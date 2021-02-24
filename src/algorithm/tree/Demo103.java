package algorithm.tree;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. 二叉树的锯齿形层序遍历
 * @author Liq
 * @date 2021/2/20
 */
public class Demo103 {



    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        int num = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        List<List<Integer>> res = new ArrayList<>();

        if(root == null) {
            return res;
        }
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> integerList = new LinkedList<>();
            while(size > 0) {
                TreeNode poll = queue.poll();
                if((num&1)==0) {
                    integerList.addFirst(poll.val);
                } else {
                    integerList.addLast(poll.val);
                }
                if(poll.left != null) {
                    queue.offer(poll.left);
                }
                if(poll.right != null) {
                    queue.offer(poll.right);
                }
                size--;
            }
            num++;
            res.add(integerList);
        }

        return res;

    }


    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        travel(root, res, 0);
        return res;
    }

    private void travel(TreeNode cur, List<List<Integer>> res, int level) {
        if (cur == null) {
            return;
        }
        //如果res.size() <= level说明下一层的集合还没创建，所以要先创建下一层的集合
        if (res.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            res.add(newLevel);
        }
        //遍历到第几层我们就操作第几层的数据
        List<Integer> list = res.get(level);
        //这里默认根节点是第0层，偶数层相当于从左往右遍历，
        // 所以要添加到集合的末尾，如果是奇数层相当于从右往左遍历，
        // 要把数据添加到集合的开头
        if (level % 2 == 0) {
            list.add(cur.val);
        } else {
            list.add(0, cur.val);
        }
        //分别遍历左右两个子节点，到下一层了，所以层数要加1
        travel(cur.left, res, level + 1);
        travel(cur.right, res, level + 1);
    }

}





























