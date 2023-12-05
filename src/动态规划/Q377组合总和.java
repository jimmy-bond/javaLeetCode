package 动态规划;

public class Q377组合总和 {
    public int combinationSum4(int[] nums, int target)
    {
        //排列求和和组合求和是两个截然不同的遍历顺序
        //组合求和要求先遍历物品，再遍历背包容量
        //排列求和要求先遍历背包容量，再遍历物品
        int[]dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++)
            for(int j = 0; j < nums.length; j++)
                if(i >= nums[j])
                dp[i] += dp[i-nums[j]];
        return dp[target];
    }
}
