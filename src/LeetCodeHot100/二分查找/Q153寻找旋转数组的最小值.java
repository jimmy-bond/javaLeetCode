package LeetCodeHot100.二分查找;

public class Q153寻找旋转数组的最小值 {
    public int findMin(int[] nums) {
        int left = 0, n = nums.length;
        int right = n - 2;
        while(left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid] > nums[n-1]){
                left = mid + 1;
            }
            else{
                right= mid - 1;
            }
        }
        return left;
    }
}
