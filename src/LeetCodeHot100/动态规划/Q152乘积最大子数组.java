package LeetCodeHot100.动态规划;

public class Q152乘积最大子数组 {
    public int maxProduct(int[] nums) {
        //确定了状态转移方程，但是状态过多时不够分析时可以增加dp数组的维度
      int[]maxDp = new int[nums.length];
      int[]minDp = new int[nums.length];
      maxDp[0] = nums[0];
      minDp[0] = nums[0];
      for(int i = 1; i < nums.length; i++)
      {
          if(nums[i] >= 0){
              maxDp[i] = Math.max(nums[i],maxDp[i-1] * nums[i-1]);
              minDp[i] = Math.min(nums[i],minDp[i-1] * nums[i-1]);
          }
          else {
              maxDp[i] = Math.max(nums[i],minDp[i-1]* nums[i]);
              minDp[i] = Math.min(nums[i], maxDp[i-1] * nums[i]);
          }
      }
      int ans = maxDp[0];
        for (int i = 1; i < maxDp.length; i++) {
            ans = Math.max(ans,maxDp[i]);
        }
        return ans;
    }
}
