package algorithm.leetcode;

import algorithm.tree.TreeNode;

/**
 * @author liq
 * @date 2021/2/13
 */


public class SmallestBST {




    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums,0,nums.length-1);

    }

    public TreeNode helper(int[] nums, int left, int right) {

        if(left > right) {
            return null;
        }
        // 数组有序，中间值当做最小树的根
        int mid = left + right >> 1 + left;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,left,mid-1);
        root.right = helper(nums,mid+1,right);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};

        TreeNode node = new SmallestBST().sortedArrayToBST(nums);

    }


}
