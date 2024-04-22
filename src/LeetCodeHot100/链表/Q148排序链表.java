package LeetCodeHot100.链表;

public class Q148排序链表 {
    //采用了归并排序的方法
    //归并排序就是将集合不断二分，直到不能分，然后两个值相比然后归并
    //递归方法
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode node = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(node);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while(left != null && right != null){
            if(left.val < right.val){
                h.next = left;
                left = left.next;
            }else{
              h.next = right;
              right = right.next;
            }
            h = h.next;
        }
        h.next = left==null ? right: left;
        return res.next;
    }
    //迭代方法
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) return head;

        // 统计链表长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode dummy = new ListNode(0, head);

        // 子链表长度，从 1 开始合并，每次翻倍。（这个 for 循环主要是增大两个合并数组的数组长度）
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummy;  // prev 用于连接合并后排序好的链表，相当于记录结果
            ListNode cur = dummy.next;  // cur 记录拆分链表的位置

            // 每次遍历整条链表，将链表拆分成若干个长度为 subLength 的子链表，然后合并。（这个 while 循环才是真正的拆分合并）
            while (cur != null) {
                // 1. 拆分subLength长度的链表1
                ListNode head_1 = cur;      // 第一个链表的头节点
                // 找到第一个链表的尾结点，拆分出长度为subLength的链表1，
                // cur.next != null是为了防止下面的head_2 = cur.next（cur=null报错），或者也可以像下面next一样先判断一下cur != null
                for (int i = 1; i < subLength && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }

                // 2. 拆分subLength长度的链表2
                ListNode head_2 = cur.next;     // 第二个链表的头结点，即链表1尾部的next
                cur.next = null;        // 断开第一个链表和第二个链表的连接
                cur = head_2;       // 第二个链表的头节点，重新赋给cur，继续寻找第二个链表的尾结点
                // 寻找第二个链表的尾结点，再拆分出长度为subLen的链表2
                for (int i = 1; i < subLength && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }

                // 3. 断开第二个链表和剩下链表的连接
                ListNode next = null;   // next 为剩下链表的头结点（即拆分完两个链表后第二个链表结束位置的next）
                // 第二个链表的尾结点可能为空，不为空时才能更新next，所以不能直接 next = cur.next;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;    // 断开第二个链表和剩下链表的连接
                }

                // 到这里，已经拆分完毕了，head_1、head_2 都为一条单独的链表，next 为剩下未拆分的链表

                // 4. 合并两个subLength长度的有序链表
                ListNode merged = mergeTwoLists(head_1, head_2);

                prev.next = merged;     // prev.next 指向排序好的链表，连接结果
                // 将prev移动到subLength × 2 的位置，以连接下一次合并的结果
                while (prev.next != null) {
                    prev = prev.next;
                }
                cur = next;     // 将剩余链表next赋给cur，继续下一次的拆分（循环合并剩下的链表）
            }
        }
        return dummy.next;
    }

    // 题21. 合并两个有序链表
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
