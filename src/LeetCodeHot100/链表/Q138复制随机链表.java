package LeetCodeHot100.链表;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Q138复制随机链表 {
    public Node copyRandomList(Node head) {
       Node pre = head;
       while(pre != null){
           Node tmp = new Node(pre.val);
           tmp.next = pre.next;
           pre.next = tmp;
           pre = tmp.next;
       }
       pre = head;
       while(pre != null && pre.next != null){
           if(pre.random != null){
               pre.next.random = pre.random.next;
           }

         pre = pre.next.next;
       }
       Node start = new Node(0);
       Node cur = start;
       pre = head;
       while(pre != null){
           cur.next = pre.next;
           cur = cur.next;
           pre.next = cur.next;
           pre = pre.next;
       }
       return start.next;
    }

}
