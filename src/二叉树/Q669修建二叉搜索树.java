package 二叉树;

import javafx.scene.transform.Rotate;

class Q699 {
     public TreeNode trimBST(TreeNode root, int low, int high) {
         int [] n = new int[1];
         System.out.println(n.length);
         if(root == null) return root;
        if(root.val < low) return trimBST(root.right,low,high);
        if(root.val > high ) return trimBST(root.left,low,high);
        root.left = trimBST(root.left,low,high);
       root.right =  trimBST(root.right,low,high);
        return root;
     }

}
