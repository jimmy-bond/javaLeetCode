package 滑动窗口;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Q209 {
    //长度最小子数组
    /*给定一个含有 n 个正整数的数组和一个正整数 target 。
    找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。*/
    public int minSubArrayLen(int target, int[] nums) {
       int left = 0;
       int min = nums.length + 1;
       int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target){
                min = Math.min(right - left + 1,min) ;
                sum-=nums[left];
                left++;
            }
        }
        if(min == nums.length + 1){
            return  0;
        }
        return  min;
    }

    @Test
    public  void  kk(){
        int []nums ={1,1,1};
        System.out.println(minSubArrayLen(15, nums));
    }
}
