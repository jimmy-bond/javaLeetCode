package 贪心算法;
import java.util.List;
import java.util.List;
import java.util.LinkedList;
 class Q763 {
     public List<Integer> partitionLabels(String s) {
         List<Integer> list = new LinkedList<>();
         int[] arr = new int[27];
         //更新每个字母最后一次出现的位置
         for (int i = 0; i < s.length(); i++) {
             arr[s.charAt(i) - 'a'] = i;
         }
         int left = 0;
         int right = 0;
         for(int i = 0; i < s.length(); i++)
         {
             if(right == i) {
                 list.add(right - left + 1);
                 left = i + 1;
             }
             right = Math.max(right,arr[s.charAt(i) - 'a']);
         }
         return list;
     }
}
