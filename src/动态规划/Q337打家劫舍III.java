package 动态规划;

import java.security.SignatureException;

public class Q337打家劫舍III {

//后序遍历
    public class TreeNode {
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

   //0表示不偷当前节点，1表示偷取当前节点
    public int rob(TreeNode root) {
        int[] ans = robtree(root);
        return Math.max(ans[0],ans[1]);
    }

    public int[] robtree(TreeNode root)
    {
        int[]dp = new int[2];
        if(root == null) return dp;
        int[] left = robtree(root.left);
        int[] right = robtree(root.right);
        //偷当前节点值
        dp[1] = root.val + left[0] + right[1];
        dp[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1] );
        //不偷当前节点
        return  dp;
    }

}