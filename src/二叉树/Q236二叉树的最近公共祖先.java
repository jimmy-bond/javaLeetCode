package 二叉树;

class Q236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null && right ==null) return right;
       else if(left != null && right == null) return left;
        else if(left == null && right != null) return null;
        else{
            return root;
        }
    }
}
