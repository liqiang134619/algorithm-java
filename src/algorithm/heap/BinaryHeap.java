package algorithm.heap;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * 二叉堆
 *
 * @author liq
 * @date 2020/11/15
 */
public class BinaryHeap<T extends Comparable<? super T>> {


    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 堆大小
     */
    private int currentSize;

    /**
     * 堆数组
     */
    private T[] array;


    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }


    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = (T[]) new Comparable[capacity + 1];
    }

    public BinaryHeap(T[] items) {
        currentSize = items.length;
        array = (T[]) new Comparable[(currentSize + 2) * 11 / 10];
        int i = 1;
        for (T item : items) {
            array[i++] = item;
        }
        buildHeap();
    }


    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    private void buildHeap() {
        // 从倒数第一个父节点开始
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);

        }
    }


    /**
     * Internal method to percolate down in the heap.
     *
     * @param hole the index at which the percolate begins.
     */
    private void percolateDown(int hole) {
        int child;
        T tmp = array[hole];

        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;

            // 有右孩子且右孩子节点小于左孩子节点
            if (child != currentSize &&
                    array[child + 1].compareTo(array[child]) < 0) {
                child++;
            }
            if (array[child].compareTo(tmp) < 0) {
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = tmp;
    }


    public void insert(T t) {
        if (currentSize == array.length - 1) {
            enlargeArray(array.length * 2 + 1);
        }
        // 添加在最后一个位置上
        int hole = ++currentSize;

        // 开始上虑
        for (array[ 0 ] = t; t.compareTo(array[hole / 2]) < 0; hole /= 2) {
            // 避免三次交换
            array[hole] = array[hole / 2];
        }
        array[hole] = t;

    }

    /**
     * Find the smallest item in the priority queue.
     *
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public T findMin() {
        return array[1];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }


    /**
     * Remove the smallest item from the priority queue.
     *
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public T deleteMin() {
        T minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);

        return minItem;
    }


    private void enlargeArray(int newSize) {
        T[] old = array;
        array = (T[]) new Comparable[newSize];
        System.arraycopy(old, 0, array, 0, old.length);
    }

    public static void main(String[] args) {
        int numItems = 10000;
        BinaryHeap<Integer> h = new BinaryHeap<>();
        int i = 37;

        for (i = 37; i != 0; i = (i + 37) % numItems) {
            h.insert(i);
        }

        Arrays.stream(h.array).forEach(System.out::println);
//        for (int i1 = 0; i1 < 20; i1++) {
//            System.out.println(h.deleteMin());
//        }


    }
}
