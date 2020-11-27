package algorithm.tree;

/**
 *给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 *  
 *
 * @author Liq
 * @date 2020-11-27
 */
public class Demo654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {

        if(left > right) {
            return null;
        }
        int max = nums[left];
        int i;
        int index = left;
        for (i = left; i <= right; i++) {
            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode treeNode = new TreeNode(max);
        treeNode.left = helper(nums,left,index-1);
        treeNode.right = helper(nums,index+1,right);
        return treeNode;

    }


    public static void main(String[] args) {

        int[] nums = {3,2,1,6,0,5};
        Demo654 demo654 = new Demo654();
        TreeNode treeNode = demo654.constructMaximumBinaryTree(nums);
        System.out.println("xx");
    }


}
