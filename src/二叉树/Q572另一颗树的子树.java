package 二叉树;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class Q572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
      if(subRoot == null) return true;
      if(root == null) return  false;
      return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot)||compareTree(root,subRoot);
    }
    public  boolean compareTree(TreeNode left, TreeNode right)
    {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(left);
        deque.offerLast(right);
        while (!deque.isEmpty())
        {
            TreeNode t = deque.pollFirst();
            TreeNode two = deque.pollLast();
            if(t == null && two == null) continue;

            if (t == null || two== null || t.val != two.val) {
                return false;
            }
            deque.offerFirst(t.left);
            deque.offerFirst(t.right);
            deque.offerLast(two.right);
            deque.offerLast(two.left);
        }
        return true;
    }
}
