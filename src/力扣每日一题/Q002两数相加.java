package 力扣每日一题;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Q002两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode cur = ans;
        int sum = 0;
        while(l1 != null || l2 != null || sum != 0)
        {
            if(l1 != null) sum += l1.val;
            if(l2 != null) sum += l2.val;
            //这里是确保了下一个创造的节点不会为空，而不是在本地操作
            cur = cur.next = new ListNode(sum%10);
            sum/=10;
            if(l1 != null)     l1 = l1.next;
            if(l2 != null)      l2 = l2.next;
        }

        return  ans.next;
    }
}
