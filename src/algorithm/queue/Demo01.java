package algorithm.queue;

/**
 * @author liq
 * @date 2020/6/24
 */
public class Demo01 {

    public static void main(String[] args) {

        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(3));
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
       /* MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        circularQueue.enQueue(1);  // 返回 true
        circularQueue.enQueue(2);  // 返回 true
        circularQueue.enQueue(3);  // 返回 true
        circularQueue.enQueue(4);  // 返回 false，队列已满
        circularQueue.Rear();  // 返回 3
        circularQueue.isFull();  // 返回 true
        circularQueue.deQueue();  // 返回 true
        circularQueue.enQueue(4);  // 返回 true
        circularQueue.Rear();  // 返回 4*/
    }
}
