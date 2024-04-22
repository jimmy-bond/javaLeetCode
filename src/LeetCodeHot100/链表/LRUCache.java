package LeetCodeHot100.链表;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    //哈希表加双向链表
    private Map<Integer, ListNode> map;
    private class ListNode {

        private Integer key;
        private Integer value;
        /**
         * 前驱结点 precursor
         */
        private ListNode pre;
        /**
         * 后继结点 successor（写成 next 是照顾单链表的表示习惯）
         */
        private ListNode next;

        public ListNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private ListNode dummyHead;
    private ListNode dummyTail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        dummyHead = new ListNode(-1,-1);
        dummyTail = new ListNode(-1,-1);
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            Move2head(key);
            return node.value;
        }
        return -1;
    }

    private void Move2head(int key) {
        //先拿出node
        ListNode node = map.get(key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        //然后再添加node到head
        Add2head(node);
    }

    private void Add2head(ListNode node) {
        //获取当前头节点
        ListNode head = dummyHead.next;
        node.next = head;
        dummyHead.next = node;
        head.pre = node;
        node.pre = dummyHead;

    }

    public void put(int key, int value) {
    if(map.containsKey(key)){
        ListNode node = map.get(key);
        node.value = value;
        Move2head(key);
    }
    //容量已满
        if (map.size() == capacity) {
            // 如果满了
            ListNode oldTail = removeTail();

            // 设计 key 就是为了在这里删除
            map.remove(oldTail.key);
        }

        ListNode listNode = new ListNode(key, value);
        map.put(key,listNode);
        Add2head(listNode);
    }
    private ListNode removeTail() {
        ListNode oldTail = dummyTail.pre;
        ListNode newTail = oldTail.pre;

        // 两侧结点建立连接
        newTail.next = dummyTail;
        dummyTail.pre = newTail;

        // 释放引用
        oldTail.pre = null;
        oldTail.next = null;

        return oldTail;
    }


}