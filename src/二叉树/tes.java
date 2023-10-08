package 二叉树;

import java.util.HashMap;

public class tes {
    HashMap<Integer,Integer> memo = new HashMap<>();
    int[] pre ;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
       pre = preorder;
        for (int i = 0; i < inorder.length; i++) {
           memo.put(inorder[i],i);
        }
        return buildTree(0,preorder.length,0,inorder.length);
    }

    public TreeNode buildTree(int ps, int pe, int is, int ie) {
      if(is > ie || ps > pe )
      {return null;}
      int a = pre[ps];
        TreeNode root  = new TreeNode(a);
        int index = memo.get(a);
        root.left = buildTree(ps+1,ps+index+1,is,index);
        root.right = buildTree(ps+index+1,pe,index+1,ie);
      return root;
    }
}
