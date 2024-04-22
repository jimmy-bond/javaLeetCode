package LeetCodeHot100.二分查找;

import org.testng.annotations.Test;

import javax.naming.LinkLoopException;

public class Q33搜索旋转排序数组 {
    @Test
    public void kk(){
        System.out.println(search(new int[]{5, 1, 3}, 1));
    }

    public int search(int[] nums, int target) {
        int n = nums.length-1;
      int left = 0, right = nums.length - 1;
      while(left <= right){
          int mid = (left + right) >> 1;
          if (nums[mid] == target) {
              return mid;
          }
          if(nums[mid] >= nums[0]){
              if(target >= nums[0] && target < nums[mid]){
                  right = mid - 1;
              }
              left = mid + 1;
          }
          else{
              if(target> nums[mid] && target < nums[n]){
                  left = mid + 1;
              }
              right = mid - 1;
          }
      }
      return -1;
    }

}
