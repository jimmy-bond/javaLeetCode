import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

    @Test
    public void kk()
    {
        System.out.println(minCost(new int[]{1,2,3}, 27));

    }
    //枚举全部可能性 0次到 n-1 次
    public long minCost(int[] nums, int x) {
        long ans = Long.MAX_VALUE;
       int n = nums.length;
       long[]sum = new long[n];
        for (int i = 0; i < n; i++) {
            sum[i] = (long) i * x;
        }

        for(int i = 0; i < n; i++)
        {
            int a = nums[i];
            for(int j = i; j < n+i; j++)
            {
                a = Math.min(a,nums[j%n]);
                sum[j - i] += a;
            }
        }
        for(long i : sum)
        {
            ans = Math.min(ans,i);
        }
       /*for(int i = 0; i < n; i++)
       {
           long temp = 0;
           for(int j =0; j < n; j++)
           {
               long a = Integer.MAX_VALUE;
               for(int k =0; k <= i; k++)
               {
                   a = Math.min(a,nums[(j+k) % n]);
               }
               temp += a;
           }
           temp += (long) x * i;
           ans = Math.min(ans,temp);
       }*/

        return ans;
    }
}
