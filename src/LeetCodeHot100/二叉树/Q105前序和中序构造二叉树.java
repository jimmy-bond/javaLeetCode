package LeetCodeHot100.二叉树;

import java.util.Arrays;

public class Q105前序和中序构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(n == 0) return null;
        int leftSize = indexOf(inorder,preorder[0]);
        int[]pre1 = Arrays.copyOfRange(preorder,1,1+leftSize);
        int[]pre2 = Arrays.copyOfRange(preorder,1+leftSize,n);
        int[]ino1 = Arrays.copyOfRange(inorder,0,leftSize);
        int[]ino2 = Arrays.copyOfRange(inorder,1+leftSize,n);
        TreeNode left = buildTree(pre1,ino1);
        TreeNode right = buildTree(pre2,ino2);
        return new TreeNode(preorder[0],left,right);
    }
    private int indexOf(int[] inorder,int val){
        for (int i = 0; i < inorder.length; i++) {
            if(val == inorder[i]) return i;
        }
        return 0;
    }
}
