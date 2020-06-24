package algorithm.queue;

/**
 * @author liq
 * @date 2020/6/24
 */
public class MyCircularQueue {


    int[] data;
    int front;
    int rear;
    int size;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.data = new int[k];
        this.rear = -1;
        this.front = -1;
        this.size = k;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {

        if(this.isFull()) {
            return false;
        }

        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % this.size;
        this.data[rear] = value;
        return true;

    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {

        if (isEmpty()) {
            return false;
        }

        if (front == rear) {
            rear = -1;
            front = -1;
            return true;
        }
        front = (front + 1) % this.size;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return this.data[front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return this.data[rear];

    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return front == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (rear + 1) % this.size == front;
    }
}
