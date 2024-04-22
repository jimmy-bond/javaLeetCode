package LeetCodeHot100.链表;

import com.sun.xml.internal.ws.handler.HandlerException;

public class Q206反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode ans = new ListNode();
        while(head != null)
        {
            int x = head.val;
            ListNode ne = new ListNode(x);
            ne.next = ans.next;
            ans.next = ne;
            head = head.next;
        }

        return ans.next;

    }
    //递归方法解决
    private ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) return pre; // 终止条件
        ListNode res = recur(cur.next, cur);  // 递归后继节点
        cur.next = pre;              // 修改节点引用指向
        return res;                  // 返回反转链表的头节点
    }


}
