package 二叉树;

import java.util.ArrayDeque;
import java.util.Queue;

class filpTree {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root != null) queue.add(root);
        while (!queue.isEmpty())
        {
            int len = queue.size();
            TreeNode t = queue.peek();
            while (len > 0)
            {
                t = queue.poll();
                if(t.left != null) queue.add(t.left);
                if(t.right != null) queue.add(t.right);
                TreeNode temp = t.left;
                t.left = t.right;
                t.right = temp;
                len--;
            }

        }
        return root;

    }
}
