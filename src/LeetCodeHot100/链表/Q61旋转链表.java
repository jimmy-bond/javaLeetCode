package LeetCodeHot100.链表;

public class Q61旋转链表 {
    //快慢指针，或者闭环
    public ListNode rotateRight(ListNode head, int k) {
            if(head == null || k == 0) return null;
            int size = 1;
            ListNode tail = head;
        while (tail.next != null) {
            size++;
            tail = tail.next;
        }
        tail.next = head;
        k = k % size;
        while(k > 0){
            k--;
            head = head.next;
        }
        ListNode ans = head.next;
        head.next = null;
        return ans;
    }
}
