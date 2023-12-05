package 动态规划;

 class Q509 {
     public int fib(int n) {
         int[] ans = new int[n+1];
         ans[0] = 0;
         ans[1] = 1;
         for(int i = 2; i < n+1; i++)
         {
             ans[i] = ans[i-1] + ans[i-2];
         }
         return ans[n];
     }
}
