package 双指针法;

import org.testng.annotations.Test;

public class Q26 {
    @Test
    public void test(){
        int []nums={1,1,2};
        System.out.println(removeDuplicates(nums));

    }
    public int removeDuplicates(int[] nums) {
        int slowindex =0;
        int fastindex = 0;
       while (fastindex < nums.length){
           if(nums[fastindex] == nums[slowindex]) {
               fastindex++;
               continue;
           }
           slowindex ++;
           nums[slowindex] =nums[fastindex];

       }
        return slowindex+1;
    }
}
