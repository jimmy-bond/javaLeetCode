package 二叉树;

class Q101 {
    public boolean isSymmetric(TreeNode root) {
        return compareTree(root.left,root.right);

    }
    public  boolean compareTree(TreeNode left, TreeNode right)
    {
        if(left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left == null && right == null) return true;
        if (left.val != right.val) return false;
        // 比较外侧
        boolean compareOutside = compareTree(left.left,right.right);
        // 比较内侧
        boolean compareInside = compareTree(left.right, right.left);
        return compareOutside && compareInside;
    }
}
