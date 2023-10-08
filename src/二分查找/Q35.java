package 二分查找;

public class Q35 {
    //插入位置查找
    //用二分查找
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid =(left + right)/2;
            if(nums[mid] == target) return mid;
            if(target > nums[mid]) left = mid + 1;
            if(target < nums[mid]) right = mid -1;
        }
        return left;
    }
}
