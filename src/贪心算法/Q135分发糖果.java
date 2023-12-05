package 贪心算法;

import java.util.Arrays;
import java.util.Collections;

class Q135
 {
     public int candy(int[] ratings) {
         //先判断右孩子比左孩子评分高的糖果分发，再判断左孩子评分比右孩子评分高的糖果
         //但是第二个判断要从后面开始判断，i-2和i-1的比较要用上i-1 和i的比较
         //这样就可以使得每个数局部最优
         int [] nums = new int[ratings.length];
         Arrays.fill(nums,1);
         for(int i = 1; i < ratings.length; i++)
         {
             if(ratings[i] > ratings[i-1]) nums[i] = nums[i -1 ] +1;
         }
         for(int i = ratings.length - 2; i >= 0; i--)
         {
             if(ratings[i] > ratings[ i +1])
             {
                 nums[i] = Math.max(nums[i],nums[i - 1] +1 );
             }
         }
         int sum = 0;
         for(int i : nums)
             sum += i;
         return sum;
     }

}
