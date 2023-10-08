package 栈与队列;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/*请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。

        实现 MyStack 类：

        void push(int x) 将元素 x 压入栈顶。
        int pop() 移除并返回栈顶元素。
        int top() 返回栈顶元素。
        boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。*/
class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
     q1 = new ArrayDeque<>();
     q2 = new ArrayDeque<>();
    }

    public void push(int x) {
        while(!q1.isEmpty())
        {
            q2.add(q1.poll());
        }
        q1.add(x);
        while(!q2.isEmpty())
        {
            q1.add(q2.poll());
        }
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}