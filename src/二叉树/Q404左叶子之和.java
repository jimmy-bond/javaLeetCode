package 二叉树;

class Q404 {
    static int count =0;
    public int sumOfLeftLeaves(TreeNode root) {
    if(root == null ) return 0;
    setCount(root);
    return count;
    }
    public void setCount(TreeNode root)
    { if(root==null) return;
        if(root.left != null && root.left.left==null && root.left.right==null) count+=root.left.val;
        setCount(root.left);
        setCount(root.right);
    }

}
