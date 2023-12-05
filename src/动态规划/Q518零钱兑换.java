package 动态规划;

import java.util.Collections;

public class Q518零钱兑换
{
    public static void main(String[] args) {
        int[] coins = new int[3];
        coins = new int[]{1, 2, 5};
        change(5,coins);
    }
    //这是一个完全背包问题
    public static int change(int amount, int[] coins)
    {
        //dp[j]表示组成j的方法有多少种
        int[]dp =new int[amount + 1];
        dp[0] = 1;
       /* for(int i = 0; i < coins.length; i++)
        {
            System.out.println();
            for(int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
                System.out.print(dp[j]+" ");

            }
           }*/

        for (int j = 0; j <= amount; j++) { // 遍历背包容量
            System.out.println();
            for (int i = 0; i < coins.length; i++) { // 遍历物品
                if (j - coins[i] >= 0) dp[j] += dp[j - coins[i]];
                System.out.print(dp[j] + " ");
            }
        }
        return dp[amount];

    }


}
