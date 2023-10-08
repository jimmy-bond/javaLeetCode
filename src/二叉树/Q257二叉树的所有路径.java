package 二叉树;

import java.util.ArrayList;
import java.util.List;

class Q257 {
    public static void main(String[] args) {
      
    }
     public List<String> binaryTreePaths(TreeNode root)
     {
         List<String> ans = new ArrayList<>();
        if(root == null) return ans;
        List<Integer> path = new ArrayList<>();
        recordPath(root,ans,path);
        return ans;
     }
     public void recordPath(TreeNode root,List<String> ans,List<Integer> path)
     {
         path.add(root.val);
         if(root.left == null && root.right==null)
         {
             StringBuilder sb = new StringBuilder();
             for (int i = 0; i < path.size() - 1; i++)
             {
                 sb.append(path.get(i)+"->");
             }
            sb.append(path.get(path.size()-1));
             ans.add(sb.toString());
             return;
         }
        if(root.left != null)
        {
            recordPath(root.left,ans,path);
            path.remove(path.size()-1);
        }
        if(root.right != null)
        {
            recordPath(root.right,ans,path);
            path.remove(path.size()-1);
        }
     }
 }
