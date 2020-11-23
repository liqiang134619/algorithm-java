package algorithm.sort;

import java.util.Arrays;

/**
 * O(n^2)
 * @author liq
 * @date 2020/11/18
 */
public class BubbleSortDemo {


    private void bubbleSort(int[] a) {
        boolean flag = true;
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length - i; j++) {
                if(a[j-1] > a[j]) {
                    int tmp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = tmp;
                    // 已经有序，没有发生交换操作
                    flag =false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,88,8,9,9,93,4,4,2,32,23,42,423,41,42,41,432,435,45,46,5,234,243,64,24342,432,24,324,32,132,4};
        BubbleSortDemo bubbleSortDemo = new BubbleSortDemo();
        bubbleSortDemo.bubbleSort(a);
        Arrays.stream(a).forEach(System.out::println);

    }
}
