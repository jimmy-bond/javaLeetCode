package LeetCodeHot100.二叉树;

import sun.nio.cs.ext.MacHebrew;

public class Q534二叉树直径 {
    int ans = 1;
    public int diameterOfBinaryTree(TreeNode root) {
     dfs(root);
     return ans-1 ;
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;
        int left  = dfs(root.left) ;
        int right = dfs(root.right) ;
        ans = Math.max(ans,left + right+1 );
        return Math.max(left,right)+1;
    }
}
