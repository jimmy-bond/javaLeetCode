package 双指针法;

import java.util.Arrays;

public class Q27 {
    public static void main(String[] args) {
      int []  nums = {3,2,2,3,4,4}; int val = 3;
        System.out.println(removeElement(nums, 3));

    }
    public static int removeElement(int[] nums, int val) {
        //快慢指针法
    int slowindex = 0;
        for (int fastindex = 0; fastindex < nums.length; fastindex++) {
            if(nums[fastindex] != val){
                nums[slowindex] = nums[fastindex];
                slowindex ++;
            }
        }
        return slowindex;
    }
}
