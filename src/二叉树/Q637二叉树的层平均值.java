package 二叉树;

import java.util.*;

//求每一层的平均值
 class Q637{
    public List<Double> averageOfLevels(TreeNode root) {
    List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root != null) queue.offer(root);
        while (!queue.isEmpty())
        {
            int len = queue.size();
            int i = len;
         double sum = 0;
            while(len > 0)
            {
                TreeNode t = queue.poll();
                sum+=t.val;
                if(len ==1)
                {
                    list.add(sum/i);
                }
                len--;
                if(t.left != null) queue.add(t.left);
                if(t.right != null) queue.add(t.right);

            }

        }
        return list;
    }
 }
