package LeetCodeHot100.双指针;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.util.Arrays;

public class Q283移动零 {
    @Test
    public void kk()
    {
        moveZeroes(new int[]{0,1});
    }
    public void moveZeroes(int[] nums) {
     int slowindex = 0, fastindex = 0;
        for ( fastindex = 0; fastindex < nums.length; fastindex++) {
            if(nums[fastindex] != 0)
            {
                nums[slowindex] = nums[fastindex];
                if(fastindex != slowindex) nums[fastindex] = 0;
                slowindex++;
            }
        }
    }
}
