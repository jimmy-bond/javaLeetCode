package 二叉树;

import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.ArrayList;
import java.util.HashMap;

class Q501 {
    int maxcount;
    int count;
    ArrayList<Integer> list = new ArrayList<>();
    TreeNode pre;
    public int[] findMode(TreeNode root) {
        maxcount = 0;
        count = 0;
        pre = null;
        find(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] =list.get(i);
        }
        return res;

    }
    public void find(TreeNode root)
    {
        if(root == null) return;
        find(root.left);
        if (pre == null || root.val != pre.val) {
            //pre为空时，为最左边的树的值，初始化为一
            count = 1;
        } else {
            count++;
        }
        if(count > maxcount)
        {
            list.clear();
            list.add(root.val);
            maxcount = count;
        } else if (count == maxcount) {
            list.add(root.val);
        }
        pre = root;

        find(root.right);
    }
}
