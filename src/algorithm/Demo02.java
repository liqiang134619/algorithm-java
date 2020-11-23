package algorithm;

import sun.font.GlyphLayout;

/**
 * 最大子列和
 * @author Liq
 * @date 2020-11-23
 */
public class Demo02 {



    // 穷举所有子列求最大值 O(n^2)
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int thisSum = 0;
            for (int j = i; j < nums.length; j++) {
                thisSum += nums[j];
                if(thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return  maxSum;
    }

    public static int maxSubArray2(int[] nums) {

        int pre = 0;
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            maxSum = Math.max(pre,maxSum);
        }
        return maxSum;
    }



    public static int maxSubArray3(int[] nums) {
        return divideAndConquer(nums, 0,nums.length - 1);
    }

    private static int divideAndConquer(int[] nums,int left,int right) {

        int mid;
        int maxLeftSum;
        int maxRightSum;

        // 递归出口
        if(left == right) {
            if(nums[left] > 0) {
                return nums[left];
            } else {
                return 0;
            }
        }
        mid  = (left + right) >> 1;
        // 归求得两边子列的最大和
        maxLeftSum = divideAndConquer(nums,left,mid);
        maxRightSum = divideAndConquer(nums,mid + 1,right);


        // 计算横跨左右子列的最大和

        //从中间开始想左边扫描
        int leftBorderSum = 0;
        int maxLeftBorderSum = 0;
        for (int i = mid; i >= left ; i--) {
            leftBorderSum += nums[i];
            if(leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }
        // 同上，处理右边
        int rightBorderSum = 0;
        int maxRightBorderSum = 0;
        for (int i = mid+1; i <=right; i++) {
            rightBorderSum += nums[i];
            if(rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        // 求三者中的最大者
        return Math.max(maxLeftBorderSum + maxRightBorderSum,Math.max(maxLeftSum,maxRightSum));


    }


    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4,2,1,-1,2-4,1,3,4,6,1,-5};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));
        System.out.println(maxSubArray3(nums));


    }
}
