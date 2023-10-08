package 二叉树;

import java.util.HashMap;

//以后序遍历的最后一个元素作为切割点，为根节点，后面以此类推
 class Q106 {
     public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length,postorder,0,postorder.length);
     }
     public TreeNode build(int[] inorder,int inorderstrat,int inorderend, int[] postorder,int postorderstart,int postorderend)
     {

         int root = postorder[postorder.length-1];
         TreeNode tree = new TreeNode(root);
         int middleindex ;
         for(middleindex = inorderstrat; middleindex < inorderend; middleindex++)
         {
             if(inorder[middleindex] == root) break;
         }
        int leftinstart = inorderstrat;
         int leftinend = middleindex ;
         int rightinstart = middleindex + 1;
         int rightinend =  inorderend;

         int leftpoststart =postorderstart;
         int leftpostend =postorderstart+ middleindex - inorderstrat ;
         int rightpoststart = leftpostend;
         int rightpostend = postorderend -1 ;
         tree.left = build(inorder,leftinstart,leftinend,postorder,leftpoststart,leftpostend);
         tree.right = build(inorder,rightinstart,rightinend,postorder,rightpoststart,rightpostend);
         return tree;
     }


     //进阶版本，用map来记录就不用找循环判断index位置
    HashMap<Integer,Integer> memo = new HashMap<>();
    int[] post;

    public TreeNode dbuildTree(int[] inorder, int[] postorder) {
        for(int i = 0;i < inorder.length; i++) memo.put(inorder[i], i);
        post = postorder;
        TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    public TreeNode buildTree(int is, int ie, int ps, int pe) {
        if(ie < is || pe < ps) return null;
        int root = post[pe];
        int ri = memo.get(root);

        TreeNode node = new TreeNode(root);
        //
        node.left = buildTree(is, ri - 1, ps, ps + ri - is - 1);
        node.right = buildTree(ri + 1, ie, ps + ri - is, pe - 1);
        return node;
    }
}
