package 力扣每日一题;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q2656K元素的最大和 {
    public int maximizeSum(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            ans += nums[nums.length-1];
            nums[nums.length-1] += 1;
        }
        return ans;
    }
}
