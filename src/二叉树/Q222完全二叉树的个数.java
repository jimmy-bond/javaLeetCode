package 二叉树;
//因为完全二叉树为满二叉树的话，数量为（2^深度） - 1；
//当不为满二叉树的时候，则继续向两颗子树遍历，这样会省去遍历一些满子树的时间
 class Q222 {
     public int countNodes(TreeNode root) {
            if(root == null) return  0;
            int left = 0;
            TreeNode l = root.left;
            TreeNode r = root.right;
            int l1 =0;
            int r1 = 0;
            while(l != null)
            {
                l1 ++;
                l = l.left;
            }
            while (r != null)
            {
                r1++;
                r = r.left;
            }
            if(l1 == r1) return 2^(l1) -1;

            return countNodes(root.left) + countNodes(root.right) +1;
            //一行代码 通用
         // return countNodes(root.left) + countNodes(root.right) +1;
     }
}
