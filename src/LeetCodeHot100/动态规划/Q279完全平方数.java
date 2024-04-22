package LeetCodeHot100.动态规划;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Q279完全平方数 {
    @Test
    public void kk(){
        System.out.println(numSquares(13));
    }
    public int numSquares(int n) {
        int sqrt = (int) Math.sqrt(n);
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= sqrt; i++){
            for(int j = i*i; j < n+1; j++){
                if(dp[j - i*i] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j- i*i] + 1,dp[j]);
                }
            }
        }
        return dp[n];
    }
}
