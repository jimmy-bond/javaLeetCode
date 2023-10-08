package 双指针法;

import org.testng.annotations.Test;


public class Q977 {
    public int[] sortedSquares(int[] nums) {//创建一个数组存储答案，无需移动指针到边界的情况
        int [] s =new int[nums.length];
        int m=s.length-1;
        for(int left = 0,right=nums.length-1; left <= right;)
        {
        int a = nums[left] * nums[left];
        int b = nums[right] * nums[right];
        if(a > b) {
          s[m] = a;
          m--;
          left++;
        }
        if(b >= a){
            s[m] =b;
            m--;
            right--;
        }
        }
        return s;
    }
    @Test
    public void kk(){
    int []n={-5,-4,-3,-2,-1};
        sortedSquares(n);
    }
}
