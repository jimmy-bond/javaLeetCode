package 二叉树;

import java.util.*;

//考虑层序遍历时最后的一个元素即可，就是最右可看到的元素
class Q109{
    public List<Integer> rightSideView(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    if(root != null) queue.offer(root);
    while (!queue.isEmpty())
        {
            int len = queue.size();

            while(len >0)
            {
                TreeNode t = queue.poll();
                if(len == 1) list.add(t.val);
                len--;
                if(t.left != null) queue.add(t.left);
                if(t.right != null) queue.add(t.right);

            }

        }
    return list;
    }
}
