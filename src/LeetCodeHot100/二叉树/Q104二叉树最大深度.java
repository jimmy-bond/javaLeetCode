package LeetCodeHot100.二叉树;



import javax.swing.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Q104二叉树最大深度 {
    public int maxDepth(TreeNode root) {
        return getDepth(root);

    }
    public int getDepth(TreeNode root) {
        if(root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return 1 + Math.max(left,right);
    }
}
