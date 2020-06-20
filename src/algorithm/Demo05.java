package algorithm;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * @author Liq
 * @date 2020/6/19
 */
public class Demo05 {

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6, 7, 8, 9, 10};
        System.out.println("result:" + searchInsert1(nums, 22));
    }

    private static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    private static int searchInsert1(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;

        while (begin <= end) {
            int mid = (begin + end) >> 1;

            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                return mid;
            }
        }

        return ((begin + end) >> 1) + 1;
    }


}
