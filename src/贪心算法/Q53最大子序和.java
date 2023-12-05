package 贪心算法;

import com.sun.xml.internal.ws.message.source.PayloadSourceMessage;

class Q53 {
     public  static int maxSubArray(int[] nums)
     {
         //这个缺陷就是整个数组为负数时，返回值为0，所以可以用l来记录数组中的最大值，在返回时做判断
         //更好的方法是通过设置max为 Integer.MIN_VALUE这样就不用做判断了
         if(nums.length == 1) return nums[0];
         int sum = 0;
         int max = nums[0];
         int l = nums[0];
         for (int i = 0; i < nums.length; i++) {
             if(nums[i] > l) l = nums[i];
             sum += nums[i];
             if(sum  > 0 && max < sum) {
                 max = sum;
             }
             if(sum < 0)
             {
                 sum = 0;
             }
         }
         if(max < 0) return l;
        return  max;
     }

    public static void main(String[] args) {
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};
        int [] n = {-2,-3,-1,-5};
        System.out.println(maxSubArray(n));
    }
}
