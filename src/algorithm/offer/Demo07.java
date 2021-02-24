package algorithm.offer;

import algorithm.tree.TreeNode;

import java.util.HashMap;

/**
 * @author Liq
 * @date 2021/2/20
 */
public class Demo07 {




    HashMap<Integer,Integer> hashMap = new HashMap<>();


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1,0,inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {

        if(preLeft < preRight || inLeft < inRight) {
            return null;
        }

        TreeNode treeNode = new TreeNode(preorder[preLeft]);

        Integer pIndex = hashMap.get(preorder[preLeft]);

        // pindex-inlef 得到左子树节点0的数目
        // 左子树，root节点+1，
        treeNode.left = helper(preorder,preLeft+1,pIndex-inLeft+preLeft,inLeft,pIndex-1);
        treeNode.right = helper(preorder,pIndex-inLeft + preLeft + 1,preRight,pIndex+1,inRight);

        return treeNode;

    }
}
