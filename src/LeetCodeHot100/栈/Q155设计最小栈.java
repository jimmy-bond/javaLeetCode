package LeetCodeHot100.栈;

import com.sun.xml.internal.ws.handler.HandlerException;

public class Q155设计最小栈 {
    class MinStack {
    private Node head;
        public MinStack() {

        }

        public void push(int val) {
            if(head == null){
                head = new Node(val,val);
            }else{
                head = new Node(val, Math.min(val, head.min), head);
            }

        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
        return head.min;
        }
    }

    private class Node{
        private int val;
        private int min;
        private Node next;

        private Node(int val,int min){
            this(val,min,null);
        }
        private Node(int val,int min,Node node){
            this.val = val;
            this.min = min;
            this.next = node;
        }
    }
}
