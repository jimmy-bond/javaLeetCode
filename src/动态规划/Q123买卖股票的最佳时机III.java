package 动态规划;

public class Q123买卖股票的最佳时机III {
    //最多实现两笔交易
    //用动态规划，分4种状态，第一次持有，卖出，第二次持有，卖出
    //因此第二次的卖出状态是基于第一次卖出状态上出现的
    public int maxProfit(int[] prices) {
      int[][]dp = new int[prices.length+1][5];
      dp[0][0] = 0;
      dp[0][1] = -prices[0];
      dp[0][2] = 0;
      dp[0][3] = -prices[0];
      dp[0][4] = 0;
      for(int i = 1; i <= prices.length; i++)
      {
          dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
          dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
          dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
          dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
      }
        return dp[prices.length][4];
    }
}
