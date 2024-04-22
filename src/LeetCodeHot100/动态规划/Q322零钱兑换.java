package LeetCodeHot100.动态规划;

public class Q322零钱兑换 {
    public int coinChange(int[] coins, int amount) {

        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        //初始化dp数组为最大值
        for (int j = 0; j < dp.length; j++) {
            dp[j] = max;
        }
        dp[0] = 1;
        //先遍历物品
        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                if(dp[j - coins[i]] != max){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]] +1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
