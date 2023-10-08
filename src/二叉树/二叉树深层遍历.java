package 二叉树;

import com.google.inject.spi.ProviderInstanceBinding;
import com.sun.org.apache.xerces.internal.xs.LSInputList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class deepexplore {
   static List<List<Integer>> relist = new ArrayList<List<Integer>>();
    public static  void deep(TreeNode root)
    {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root == null) return;
        queue.offer(root);

        while (!queue.isEmpty())
        {
           int len = queue.size();
           List<Integer> list = new ArrayList<>();

           while (len > 0)
           {
               TreeNode temp = queue.poll();
               list.add(temp.val);
               if(temp.left != null) queue.offer(temp.left);
               if(temp.right != null) queue.offer(temp.right);
               len--;
           }
            relist.add(list);
        }

    }


}
