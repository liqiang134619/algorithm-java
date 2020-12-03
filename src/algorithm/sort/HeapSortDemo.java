package algorithm.sort;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Arrays;

/**
 * O(nlogn)
 * 堆排序
 * @author liq
 * @date 2020/11/16
 */
public class HeapSortDemo {



    private void heapSort(int[] a) {


        // 构造堆  O(n) 线性复杂度
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            // 从底部构建二叉堆
            percDown(a, i, a.length);
        }
        for (int i = a.length - 1; i > 0; i--) {
            // 最后一个元素交换上来
            swap(a,0,i);
            // 继续构建二叉堆
            percDown(a,0,i);
        }
    }
    private void swap(int[] a,int i,int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // 构建最大堆
    private void percDown(int[] a, int i, int length) {
        int tmp = a[i];
        int child;

        // 区别于二叉堆,下标从0开始 (2*i+1)
        for (; (2 * i + 1) < length; i = child) {
            child = (2 * i + 1);

            // 有右孩子且右孩子节点大于左孩子节点 不是最后一个节点 && 左孩子小于右孩子
            // 就是找到左右孩子的最大节点
            if(child != length -1 && a[child] < a[child + 1]) {
                child++;
            }

            // 下滤
            if(tmp < a[child]) {
                a[i] = a[child];
            } else {
                break;
            }

        }
        // 最后的插入位置
        a[i] = tmp;
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,88,8,9,9,93,4,4,2,32,23,42,423,41,42,41,432,435,45,46,5,234,243,64,24342,432,24,324,32,132,4};

        HeapSortDemo heapSortDemo = new HeapSortDemo();
        heapSortDemo.heapSort(a);
        Arrays.stream(a).forEach(System.out::println);
    }


}
