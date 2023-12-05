package 动态规划;

public class Q309最佳买卖股票含冻结期 {
    //也是分状态来解析，不同以往的持有/卖出
    //现在分为4个状态，分别为持有，卖出（2种）{保持卖出和今天卖出}，冻结期
    public int maxProfit(int[] prices) {
        int[]dp = new int[4];
        dp[0]  = -prices[0];
       for(int i = 1; i <= prices.length; i++)
       {
           int temp = dp[0];
           int temp1 = dp[2];
           dp[0] = Math.max(dp[0], Math.max(dp[3], dp[1]) - prices[i - 1]);
           dp[1] = Math.max(dp[1], dp[3]);
           dp[2] = temp + prices[i - 1];
           dp[3] = temp1;
       }
       return Math.max(dp[3],Math.max(dp[1],dp[2]));
    }
}
