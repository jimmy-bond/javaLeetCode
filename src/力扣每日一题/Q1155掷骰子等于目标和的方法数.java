package 力扣每日一题;

public class Q1155掷骰子等于目标和的方法数 {
    public int numRollsToTarget(int n, int k, int target) {
        if(n * k < target)  return 0;
        int[][]dp = new int[n+1][target+1];
        dp[0][0] = 1;
        //i为有几个骰子
        //j为组成的数

        for(int i = 1; i <= n; i++)
            for(int j = 0; j <= target; j++)
                for(int x = 1; x <= k; x++)
                {
                    if(j >= x)
                        dp[i][j] = (dp[i][j] + dp[i-1][j-x]) %1000000007;
                }
        return dp[n][target];
    }
}
