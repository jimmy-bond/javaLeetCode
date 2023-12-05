package 动态规划;

 class Q763 {
     public int minCostClimbingStairs(int[] cost) {
         int pay = 0;
         //i表示到达第i个阶梯时候的花费
         int a = 0 ;
         int b = 0;
         for(int i = 2; i <= cost.length; i++)
         {
             //到达下标为i所花费的最小值
             pay = Math.min(a + cost[i - 2] ,b + cost[i-1]);
             a = b;
             b = pay;
         }
         return pay;
     }
}
