package 动态规划;

public class Q115不同的子序列 {
    public int numDistinct(String s, String t) {
        //状态转移方程主要去考虑让不让s[i]的字符去匹配t[j]的字符
        int[][]dp = new int[s.length()+1][t.length()+1];
        for(int i = 0; i < dp.length + 1; i++) dp[i][0] = 1;
        for(int i = 1; i < dp.length;i++)
            for(int j = 1; j < dp[0].length; j++)
            {
                if(s.charAt(i-1) == t.charAt(j-1))
                {//第一个匹配为让s[i]去匹配，第二个为不让s[i]去匹配
                    //还有一维的数组压缩
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        return dp[s.length()][t.length()];
    }
}
