package algorithm.sort;

import java.util.Arrays;

/**
 * O(n^2)
 * @author liq
 * @date 2020/11/19
 */
public class InsertionSortDemo {

    private void insertionSort(int[] a) {

        int j;
        for (int i = 1; i < a.length; i++) {
            int tmp  = a[i];

            for (j = i; j > 0 && tmp < a[j-1]; j--) {
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }

    private void shellSort(int[] a) {
        int j;
        // shell 增量序列
        for(int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                int tmp = a[i];
                for (j = i; j >=gap && tmp < a[j - gap]; j-=gap) {
                    a[j] = a[j - gap];
                }
                a[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,88,8,9,9,93,4,4,2,32,23,42,423,41,42,41,432,435,45,46,5,234,243,64,24342,432,24,324,32,132,4};

        InsertionSortDemo insertionSortDemo = new InsertionSortDemo();
        insertionSortDemo.shellSort(a);
        Arrays.stream(a).forEach(System.out::println);
    }
}
