package 动态规划;

import java.util.Arrays;
import java.util.Collections;

public class Q300求最长递增子序列 {
    public int lengthOfLIS(int[] nums) {

        //i值大于j值，说明i值可以接到j后面
        int[]dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = 1;  i < nums.length; i++)
            for(int j = 0; j  < i; j ++)
            {
                if(nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
    return  dp[nums.length - 1];
    }
}
