package 二分查找;

import com.sun.corba.se.impl.resolver.BootstrapResolverImpl;
import org.testng.annotations.Test;
//二分查找
public class Q34 {
    public int[] searchRange(int[] nums, int target) {
        int [] temp = new int[2];
        if(nums == null) {
            temp[0] =-1;
            temp [1]= -1;
            return temp;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid =(left + right)/2;
            if(nums[mid] == target) {
                int index =mid;
                while (mid>0&&nums[mid-1]==target)   mid--;
                temp[0] = mid;
                while (index<nums.length&&nums[index]==target) index ++;
                temp[1] =index;

            }

            if(target > nums[mid]) left = mid + 1;
            if(target < nums[mid]) right = mid -1;
        }
        temp[0] =-1;
        temp [1]= -1;
        return temp;

    }
@Test
    public void kk(){



}
}
