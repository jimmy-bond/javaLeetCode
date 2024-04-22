package LeetCodeHot100.链表;

import java.util.List;

public class Q2两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode cur = ans;
        int sum = 0;
        while(l1 != null || l2 != null || sum != 0){
            if(l1 != null) sum += l1.val;
            if(l2 != null) sum += l2.val;
            cur = cur.next = new ListNode(sum%10);
            sum /= 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        return ans.next;
    }
}
