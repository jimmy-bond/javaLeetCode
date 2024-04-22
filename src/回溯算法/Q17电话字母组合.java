package 回溯算法;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

class Q17 {
    List<String> list = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    String[] leterMap =
            {
                    "", // 0
                    "", // 1
                    "abc", // 2
                    "def", // 3
                    "ghi", // 4
                    "jkl", // 5
                    "mno", // 6
                    "pqrs", // 7
                    "tuv", // 8
                    "wxyz", // 9
            };
     public List<String> letterCombinations(String digits) {
         if(digits == null) return list;
         find(digits,0);
         return list;
     }
     public void find(String s, int index)
     {
         if(index == s.length()) {
             list.add(sb.toString());
             return;
         }
         String str = leterMap[index];
         for(int i = 0; i <str.length(); i++)
         {
             sb.append(str.charAt(i));
             find( s , index + 1);
             sb.deleteCharAt(sb.length() - 1);
         }


     }
    @Test
    public void  kk(){
        letterCombinations("23");
    }
}
