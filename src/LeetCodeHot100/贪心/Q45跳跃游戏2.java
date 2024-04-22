package LeetCodeHot100.贪心;

import java.util.Arrays;

public class Q45跳跃游戏2 {
    public int jump(int[] nums) {
        int[]dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = i + nums[i];
            for(int j = i+1; j <= max && j < nums.length; j++){
                dp[j] = Math.min(dp[j],dp[i]+1);
            }
        }
        return dp[nums.length-1];
    }
}
