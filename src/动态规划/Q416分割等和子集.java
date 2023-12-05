package 动态规划;

import sun.swing.BakedArrayList;

import java.util.Arrays;
//01背包问题，每个元素只能用一次，
class Q416 {

    public  static boolean canPartition(int[] nums) {


        int sum = 0;

      for(int i  : nums)
      {
          sum += i;
      }
      if(sum%2 != 0) {
          return false;
      }
  //  return   backtraveling(sum/2,nums,0,0);
        sum /= 2;
        int[] dp = new int[sum + 1];
        //整数一点一点地去拿，
        for(int i = 0; i < nums.length; i++)
            for(int j = sum; j >= nums[i]; j--)
            {
                dp[j] = Math.max(dp[j],dp[j-nums[i]] + nums[i]);
                if(dp[sum] == sum)
                    return true;
            }

        return dp[sum]==sum;
    }
    //回溯算法超时
   /* public  static boolean backtraveling(int sum,int[]nums, int ans,int startindex)
    {
        if(ans == sum) return true;
        if(ans > sum) return  false;
        for(int i = startindex; i < nums.length; i++ )
        {
            ans += nums[i];
           if(backtraveling(sum, nums, ans, i + 1)) return true;
            ans -= nums[i];
        }
        return false;
    }*/
}
