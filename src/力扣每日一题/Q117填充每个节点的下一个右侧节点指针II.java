package 力扣每日一题;


import org.w3c.dom.ls.LSInput;

import java.net.DatagramPacket;
import java.util.*;

public class Q117填充每个节点的下一个右侧节点指针II {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
 //用BFS来解决
    public Node connect(Node root)
    {
        if(root == null) return null;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int len = queue.size();
            Node node = null;
            Node nodePre = null;
            for(int i = 0; i < len; i++)
            {
                if (i == 0) {
                    nodePre = queue.poll(); // 取出本层头一个节点
                    node = nodePre;
                } else {
                    node = queue.poll();
                    nodePre.next = node; // 本层前一个节点 next 指向当前节点
                    nodePre = nodePre.next;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            nodePre.next = null; // 本层最后一个节点 next 指向 null
        }
        return root;
    }

}





