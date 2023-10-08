package 二叉树;

import com.sun.org.apache.xerces.internal.xs.LSInputList;
import com.sun.xml.internal.ws.encoding.RootOnlyCodec;
import sun.security.krb5.Asn1Exception;

import java.util.*;

//从叶子节点开始向上层序遍历
//对结果反转就行
 class Q107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
      List<List<Integer>> ans = new LinkedList<>();
      List<List<Integer>> aa = new LinkedList<>();
      Queue<TreeNode> queue = new ArrayDeque<>();
      if(root != null) queue.offer(root);
      while (!queue.isEmpty())
      {
          int len = queue.size();
          List<Integer> list = new LinkedList<>();
          while(len > 0)
          {
              TreeNode t = queue.poll();
              list.add(t.val);
              len--;
              if(t.left != null) queue.add(t.left);
              if(t.right != null) queue.add(t.right);

          }
          ans.add(list);
      }

        for (int i =  ans.size() -1; i >=0; i--) {
            aa.add(ans.get(i));
        }
        return aa;
    }



}
