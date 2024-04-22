package LeetCodeHot100.二叉树;

import java.util.ArrayDeque;
import java.util.Deque;

public class 二叉搜索树中第k小的数 {
    public int kthSmallest(TreeNode root, int k) {
        //左根右遍历
        Deque<TreeNode> d = new ArrayDeque<>();
        while (root != null || !d.isEmpty()) {
            while (root != null) {
                d.addLast(root);
                root = root.left;
            }
            root = d.pollLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
        return -1; // never
    }


}
