package 力扣每日一题;
import java.util.PriorityQueue;
 class Q2530 {
     public long maxKelements(int[] nums, int k)
     {
         PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);
         for (int num : nums) {
             q.offer(num);
         }
         long ans = 0;
         for (int i = 0; i < k; ++i) {
             int x = q.poll();
             ans += x;
             q.offer((x + 2) / 3);
         }
         return ans;


     }
 }
