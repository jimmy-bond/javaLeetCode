package 动态规划;

import com.sun.xml.internal.ws.server.sei.SEIInvokerTube;

import java.security.SignatureException;
import java.util.Set;

public class Q494目标和 {
    public int findTargetSumWays(int[] nums, int target)
    {
        int sum = 0;
       for(int i : nums)
            sum += i;
       if(sum < target || Math.abs(target) > sum) return 0;
        if((sum + target) %2 != 0) return 0;
        int size = (sum + target) / 2;
        size = Math.abs(size);
        int[] ans = new int[size + 1];

        ans[0] = 1;
        for(int i = 0; i < nums.length; i++)
            for(int j = size; j >= nums[i]; j--)
                //这里的关键是ans[j] 等于 上一层的ans[j]的方法中再加上上一层中的ans[j - nums[i]]
                //注意此时的i 和 j 不是同一层的
                //这题难点主要是对size的求解转换和本层递归换算的式子
                ans[j] += ans[j  - nums[i]];
                return ans[size];
    }
}
