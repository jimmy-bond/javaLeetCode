package 力扣每日一题;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.Timer;

public class Q2008出租车的最大盈利 {
    @Test
    public void kk()
    {
        System.out.println(maxTaxiEarnings(6, new int[][]{{1, 4, 100}, {2, 5, 5}, {4, 6, 100}}));
    }
    //根据第几个乘客
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a, b) -> a[1] - b[1]);
        long[] dp = new long[rides.length+1];
        for (int i = 1; i < rides.length; i++) {
        int start = rides[i-1][0];
        int end = rides[i-1][1];
        int tips = rides[i-1][2];
        int j = search(rides,start + 1,i);
        dp[i] = Math.max(dp[i-1],end - start + tips + dp[j]);
        }
        return dp[rides.length];
    }

    private int search(int[][] nums, int ed, int r) {
        int l = 0;
       while(l < r)
       {
           int mid = (l+r >> 1);
           //这里本来就是要第一个目的地小于出发地的乘客
           if(nums[mid][1] >= ed){
               r = mid;
           }
           else{
               l  = mid+1;
           }
       }
       return l;
    }
}
