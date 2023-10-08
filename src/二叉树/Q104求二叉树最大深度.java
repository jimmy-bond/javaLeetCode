package 二叉树;

import java.util.ArrayDeque;
import java.util.Queue;

class Q104 {
    //深度是指从根节点开始计数
    //高度是指从任意一个叶节点开始计数
    public int maxDepth(TreeNode root) {

        return getDepth(root);

    }
    //递归方法解决求最大深度
    public  int getDepth(TreeNode root)
    {
        if(root == null) return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return 1+Math.max(leftDepth,rightDepth);//本身加上左右子树的最大深度
    }
    //用递归方法求最小深度
    public int getMinDepth(TreeNode root)
    {
        if(root == null) return 0;
        int leftDepth = getMinDepth(root.left);
        int rightDepth = getMinDepth(root.right);
        if(root.left == null && root.right != null)
        {
            return 1+rightDepth;
        }
        if(root.right == null && root.left != null)
        {
            return 1+leftDepth;
        }
        return 1+Math.min(leftDepth,rightDepth);
    }
    //用迭代法解决，用栈实现层序遍历即可,这个是求n叉树的深度
    public int getd(Node root)
    {
        int d = 0;
        Queue<Node> queue = new ArrayDeque<>();
       if(root != null) queue.add(root);
        while (!queue.isEmpty())
        {
            d++;
            int len = queue.size();
            while(len > 0)
            {
                Node n = queue.peek();
                for(Node i : n.children)
                {
                    queue.add(i);
                }
                len--;
                queue.poll();
            }
        }
        return d;
    }

}
