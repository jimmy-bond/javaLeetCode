package LeetCodeHot100.普通数组;

public class Q238除自身以外数组的乘积 {
    public static void main(String[] args) {
        productExceptSelf1(new int[]{1,2,3,4});
    }
    //不使用除法，使用前缀积,不保含当前的位置的前缀积
    public static int[] productExceptSelf(int[] nums) {
        int[]ans = new int[nums.length];
        int[]s1 = new int[nums.length];
        int[]s2 = new int[nums.length];
        s1[0]= s2[nums.length - 1] = 1;
        for(int i = 1; i < s1.length; i++) {
            s1[i] = nums[i-1]*s1[i-1];
        }
        for(int j = nums.length-2; j >= 0; j--){
            s2[j] = s2[j+1] * nums[j+1];
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = s1[i]*s2[i];
        }
        return ans;
    }
   // 先从前往后遍历 nums，计算每个 ans[i]前缀乘值部分，再从后往前遍历 nums，计算每个 ans[i]后缀乘值的部分，两部分相乘即是最终的 ans[i]。
    public static int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 1, j = 1; i <= n; i++) {
            ans[i - 1] = j;
            j *= nums[i - 1];
        }
        for (int i = n, j = 1; i >= 1; i--) {
            ans[i - 1] *= j; j *= nums[i - 1];
        }
        return ans;
    }



}
