package LeetCodeHot100.双指针;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Q15三数之和 {
    @Test
    public void kk()
    {
        System.out.println(threeSum(new int[]{1,-1,-1,0}));
    }
    public List<List<Integer>> threeSum(int[] nums) {

        //保证三个数相加
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        //保证三个数相加
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int a = -nums[i];
            int h = i+1;
            int t = nums.length-1;
            while(h > 0 && h < t)
            {
                int temp = nums[h] + nums[t];
                if(temp == a) {
                    List<Integer> list = new ArrayList<>();
                    list.add(-a);
                    list.add(nums[h]);
                    list.add(nums[t]);
                    ans.add(list);
                    while(h < t && nums[h] == nums[++h]);
                    while(h < t && nums[t] == nums[--t]);
                }
                else    if(temp > a){
                    while(h < t && nums[t] == nums[--t]);

                }
                else {
                    while(h < t && nums[h] == nums[++h]);
                }
            }
        }
        return ans;
    }
}
