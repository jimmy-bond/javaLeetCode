package LeetCodeHot100.链表;

public class Q24两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
     ListNode pre = new ListNode(0);
     pre.next = head;
     ListNode tmp = pre;
     while(tmp.next != null && tmp.next.next != null){
         ListNode start = tmp.next;
         ListNode end = tmp.next.next;
         tmp.next = end;
         start.next = end.next;
         end.next = start;
         tmp = start;
     }
     return pre.next;
    }
}
