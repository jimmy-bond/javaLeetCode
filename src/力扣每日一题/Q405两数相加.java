package 力扣每日一题;

import java.util.Stack;

public class Q405两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode ans = new ListNode();
        ListNode c = new ListNode();
        c = ans;
        int temp = 0;
        while(l1 != null || l2 !=null)
        {
            if(l1 != null) temp += l1.val;
            if(l2 != null) temp += l2.val;
            ans.next = new ListNode(temp % 10);
            ans = ans.next;
            temp /= 10;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return reverse(c.next);
    }
    public ListNode reverse(ListNode l)
    {
        Stack<Integer> stack = new Stack<>();
        while(l != null)
        {
            stack.push(l.val);
            l = l.next;
        }
        ListNode cur = new ListNode();
        l = cur;
        while (!stack.isEmpty())
        {
            cur.next = new ListNode(stack.pop());
            cur = cur.next;
        }
        return l.next;
    }
}
