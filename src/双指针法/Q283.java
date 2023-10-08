package 双指针法;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Q283 {
    //快慢指针
    @Test
    public void test(){
        int[] nums={0,1,0,3,12};
        moveZeroes(nums);

    }
    public void moveZeroes(int[] nums) {
   int slowindex = 0;
   int fastindex = 0;
        if(nums.length == 1) return;
  for (fastindex=0;fastindex<nums.length;fastindex++){
      if(nums[fastindex] != 0){
          nums[slowindex] =nums[fastindex];
         if(fastindex != slowindex) nums[fastindex] = 0;
          slowindex++;
      }

  }

    }
}
