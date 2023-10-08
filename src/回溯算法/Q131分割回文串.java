package 回溯算法;

import org.yaml.snakeyaml.external.com.google.gdata.util.common.base.Escaper;
import sun.swing.BakedArrayList;

import javax.swing.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/*给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
        回文串 是正着读和反着读都一样的字符串。
        示例 1
        输入：s = "aab"
        输出：[["a","a","b"],["aa","b"]]*/
class Q131 {
   //切割字符串，每次返回时会进行for循环遍历所有的可能，当不符合结果和i循环到底时就会结束这一段的回溯算法
     Deque<String> deque = new LinkedList<>();
     List<List<String>> ans = new LinkedList<>();

     public List<List<String>> partition(String s) {
          backTraveling(s,0);
          return  ans;
     }
     public void backTraveling(String s, int startindex)
     {
          if(startindex == s.length()) {
               ans.add(new LinkedList(deque));
               return;
          }
          for(int i = startindex; i < s.length(); i++)
          {
               if(isPalindrome(s,startindex,i)){
                    String str = s.substring(startindex, i + 1);
                    deque.addLast(str);
               }
               else {
                    continue;
               }
               backTraveling(s, i +1 );
               deque.removeLast();
          }
     }
     //递归判断回文串
     public boolean isPalindrome(String s,int head, int end)
     {
          for (int i = head, j = end; i < j; i++, j--) {
               if (s.charAt(i) != s.charAt(j)) {
                    return false;
               }
          }
          return true;
     }
}
