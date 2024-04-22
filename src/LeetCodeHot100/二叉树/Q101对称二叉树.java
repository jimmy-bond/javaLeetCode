package LeetCodeHot100.二叉树;

public class Q101对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return compareTree(root.left,root.right);
    }

    private boolean compareTree(TreeNode left, TreeNode right) {
        if(left == null && right != null) return false;
        if(left != null && right == null) return false;
        if(left == null && right == null) return true;
        if(left.val != right.val) return  false;
        boolean out = compareTree(left.left,right.right);
        boolean in = compareTree(left.right,right.left);
        return in && out;
    }
}
