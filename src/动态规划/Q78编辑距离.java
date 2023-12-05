package 动态规划;
//这里编辑距离，当i，j字符对应相等时不做变化，当不相等时，对比增删改的最小操作数，取最小值
public class Q78编辑距离 {
    public static void main(String[] args) {
        minDistance("","a");
    }
    public static int minDistance(String word1, String word2) {
        int[][] dp  = new int[word1.length()+1][word2.length() + 1];
        for(int i = 0; i <= word1.length(); i++)
        {
            dp[i][0] = i;
        }
        for(int j = 0; j <= word2.length(); j++)
            dp[0][j] = j;

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i -1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else{
                    //增删改
                    dp[i][j] = Math.min(dp[i-1][j-1] +1 ,Math.min(dp[i-1][j] + 1,dp[i][j-1] + 1));
                }
            }
        }
        System.out.println(dp[word1.length()][word2.length()]);
        return dp[word1.length()][word2.length()];
    }
}
