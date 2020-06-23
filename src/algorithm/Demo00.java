package algorithm;

/**
 * @author Liq
 * @date 2020/6/23
 */
public class Demo00 {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;

        System.out.println(kthToLast(listNode1, 2));

    }

    private static int kthToLast(ListNode head, int k) {

        ListNode pre = head;
        k = k -1;
        while(k > 0) {
            head = head.next;
            k--;
        }

        while(head.next!=null){
            pre = pre.next;
            head = head.next;
        }
        return pre.val;
    }
}
