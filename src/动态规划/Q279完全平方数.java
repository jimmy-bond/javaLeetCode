package 动态规划;

public class Q279完全平方数 {
    public static void main(String[] args) {
        System.out.println(numSquares(1));
    }
    public static  int numSquares(int n) {
    int[]dp = new int[n+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int i = 1; i <= Math.sqrt(n); i++)
            for(int j = i*i; j <= n; j++)
            {
                //if(dp[j - i*i] != Integer.MAX_VALUE)
               // { 可以不用这个判断条件，因为1肯定可以凑成任意的数值
                    dp[j] = Math.min(dp[j],dp[j-i*i] + 1);

                //}
            }
    return dp[n];
    }
}
