package algorithm.sort;

import java.util.Arrays;

/**
 * @author liq
 * @date 2020/11/19
 */
public class QuickSortDemo {


    private void quickSort(int[] a,int leftIndex, int rightIndex) {

        if(leftIndex >= rightIndex) {
            return;
        }
        int left = leftIndex;
        int right = rightIndex;
        int key = a[left];
        while(left < right) {
            // 找到第一个小于基准值
            while (left < right && a[right] >= key) {
                right--;
            }

            a[left] = a[right];

            // 找到第一个大于基准值
            while (left < right && a[left] <= key) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = key;
        quickSort(a, leftIndex,left - 1);
        quickSort(a,right + 1,rightIndex);
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,88,8,9,9,93,4,4,2,32,23,42,423,41,42,41,432,435,45,46,5,234,243,64,24342,432,24,324,32,132,4};
        QuickSortDemo quickSortDemo = new QuickSortDemo();
        quickSortDemo.quickSort(a,0,a.length-1);
        Arrays.stream(a).forEach(System.out::println);

    }
}
