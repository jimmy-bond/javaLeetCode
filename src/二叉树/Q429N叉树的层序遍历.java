package 二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
class Q429N {
    public List<List<Integer>> levelOrder(Node root) {
     List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue  = new ArrayDeque<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty())
        {
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            while (len > 0)
            {
                Node n = queue.poll();
                list.add(n.val);
                queue.addAll(n.children);
                len--;
            }
            ans.add(list);
        }
        return  ans;
    }
}
