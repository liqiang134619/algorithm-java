package algorithm.leetcode;

import java.util.Arrays;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * @author Liq
 * @date 2020/6/23
 */
public class Demo977 {

    public static void main(String[] args) {
        int[] nums = {-2,0};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }


    private static int[] sortedSquares1(int[] A) {
        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            result[i] = A[i] * A[i];
        }
        Arrays.sort(result);
        return result;
    }

    private static int[] sortedSquares(int[] A) {
        // 先找到中位数
        int right = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                right = i;
                break;
            }
        }
        int left = right - 1;
        int count = 0;
        int[] re = new int[A.length];
        while (right < A.length || left >= 0) {
            if (right > A.length - 1) {
                re[count++] = A[left] * A[left];
                left--;
            } else if (left < 0) {
                re[count++] = A[right] * A[right];
                right++;
            } else if (A[right] * A[right] <= A[left] * A[left]) {
                re[count++] = A[right] * A[right];
                right++;
            } else {
                re[count++] = A[left] * A[left];
                left--;
            }

        }
        return re;
    }

    private static int[] sortedSquares2(int[] A) {
        int N = A.length;
        int j = 0;
        while (j < N && A[j] < 0) {
            j++;
        }
        int i = j-1;

        int[] ans = new int[N];
        int t = 0;

        while (i >= 0 && j < N) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
            } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }

        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }
        while (j < N) {
            ans[t++] = A[j] * A[j];
            j++;
        }

        return ans;
    }
}
