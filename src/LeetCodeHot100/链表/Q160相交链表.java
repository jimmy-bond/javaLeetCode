package LeetCodeHot100.链表;


import java.util.List;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
          val = x;
          next = null;
      }
    ListNode() {}
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


public class Q160相交链表 {
    //这个让他们走相同的步数，如果有相交点指针则一定会相等
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pa = headA, pb = headB;
        while(pa != pb)
        {
           pa =  pa == null ? headB :pa.next;
           pb = pb == null ? headA : pb.next;
        }
        return pa;
    }
}
