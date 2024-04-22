package LeetCodeHot100.链表;

public class Q19删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre = head;
        ListNode st = pre, end = pre;
        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        if(end.next == null) {
            pre.next = pre.next.next;
        }
        while(end.next != null){
            end = end.next;
            st = st.next;
        }
        st.next = st.next.next;
        return pre.next;
    }
}
