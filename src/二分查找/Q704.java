package 二分查找;

import java.lang.annotation.Target;

public class Q704 {
    public static void main(String[] args) {
        int [] nums={1,3,5,7};
        System.out.println(search(nums, 7));

    }
    public static int search(int[] nums, int target) {
        int left = 0;
        int  right = nums.length-1;

    while ( left <= right ){
        int mid = ( left + right )/ 2;
        if(nums[mid]== target){
            return mid;
        }
        if(target > nums[mid]){
            left = mid + 1;
        }
        if(target < nums[mid]){
            right = mid - 1;
        }

    }
 return -1;
    }

}
