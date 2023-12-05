package 力扣每日一题;

public class Q2216美化数组的最小删除数 {
    public int minDeletion(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if((i-ans) % 2 == 0 && i+1< nums.length && nums[i] == nums[i+1]){
                ans++;
            }
        }
        return (nums.length - ans) % 2 != 0 ?ans+1:ans;

}
}
