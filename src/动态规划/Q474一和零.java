package 动态规划;

public class Q474一和零 {
    //对于子集的字符串要么添加，就变成dp[i-zero][j-one] + 1
    //或者不添加保留原状
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs)
        {
            int zero = 0;
            int one = 0;
            for(char c : s.toCharArray())
            {
                if(c == '0') zero++;
                else one++;
            }
            for(int i = m; i >= 0; i--)
                for(int j = n; j >= 0; j--)
                    dp[i][j] = Math.max(dp[i-zero][j-one] + 1,dp[i][j]);
        }
        return dp[m][n];
    }

}
