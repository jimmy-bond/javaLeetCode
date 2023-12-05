package 动态规划;

class Q343 {
    public int integerBreak(int n)
    {
        int [] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        int max;
        for(int i = 3; i < n+1; i++)
        {
           for(int j = 1; j < i - j; j++)
           {
               //j * (i -j)表示 i - j 已经不能再分
               //j * dp[i - j] 表示i - j 还能再分
                dp[i] = Math.max(j*(i - j),j*dp[i - j]);
           }
        }
        return dp[n];
    }
}
