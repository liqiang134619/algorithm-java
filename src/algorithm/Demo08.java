package algorithm;

import java.util.Arrays;

/**
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * A.length == n + m
 *
 * @author Liq
 * @date 2020/6/23
 */

public class Demo08 {

    public static void main(String[] args) {

        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }

    private static void merge(int[] A, int m, int[] B, int n) {
        int re = m + n -1;
        m = m -1;
        n = n -1;
        while (n >= 0 && m >= 0) {
            if(A[m] >= B[n]) {
                A[re] = A[m];
                m--;
                re --;
            } else {
                A[re] = B[n];
                re--;
                n--;
            }
        }
        while (n >= 0) {
            A[re] = B[n];
            re--;
            n--;
        }
    }



    private static void merge1(int[] A, int m, int[] B, int n) {
        if (n >= 0) {
            System.arraycopy(B, 0, A, m, n);
        }
        Arrays.sort(A);
    }
}
