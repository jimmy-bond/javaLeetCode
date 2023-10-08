package 二叉树;

import java.util.ArrayList;
import java.util.List;

class Q617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1,root2);

    }
    public  TreeNode merge(TreeNode r1,TreeNode r2)
    {
        TreeNode root = new TreeNode();
        if(r1 !=null && r2 != null)
        {
            root.val = r1.val + r2 .val;
        }
        if(r1 == null && r2 != null)
        {
            root = r2;
            return root;
        }
        if(r2 == null && r1 != null)
        {
            root = r1;
            return root;
        }
        if(r1 == null) return null;
        root.left = merge(r1.left,r2.left);
        root.right = merge(r1.right,r2.right);
        return  root;
    }

}
