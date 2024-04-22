package LeetCodeHot100.二叉树;

import java.util.ArrayList;
import java.util.List;

public class Q114二叉树展开为链表 {
    List<Integer> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while(root != null && root.right != null){
            root = root.right;
        }
        root.right = tmp;
    }
}
