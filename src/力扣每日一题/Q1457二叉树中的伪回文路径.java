package 力扣每日一题;


import org.testng.annotations.Test;

import java.beans.beancontext.BeanContext;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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

public class Q1457二叉树中的伪回文路径 {
    public int pseudoPalindromicPaths (TreeNode root) {
        int[]p =new int[10];
        return dfs(p,root);
    }
    public int dfs(int[]p,TreeNode root)
    {
        if(root == null) return 0;
        p[root.val] ^=1;
        int ans = 0;
        if(root.left == root.right)
        {
            ans = count1(p) <=1 ? 1:0;
        }
        else {
            ans = dfs(p,root.left)+ dfs(p,root.right);
        }
        return ans;
    }

    private int count1(int[] p) {
        int cnt = 0;
        for (int x : p) {
            cnt += x;
        }
        return cnt;
    }




}
