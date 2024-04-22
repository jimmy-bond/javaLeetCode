package LeetCodeHot100.普通数组;

public class Q189轮转数组 {
    public static void main(String[] args) {
        rotate(new int[]{1,2},3);
    }
    public static void rotate(int[] nums, int k) {
    int len = nums.length;
    int time = k % len;
    if(time == 0) return;
    int[]a = nums.clone();
    int start = len - time;
    int i = 0;
    for(;start < len; start++)
    {
        nums[i] = a[start];
        i++;
    }
    for(int j = 0; j < len -time; j++)
    {
        nums[i] = a[j];
        i++;
    }
    int b = 1;
    }
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }


}
