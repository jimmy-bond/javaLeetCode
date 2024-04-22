package LeetCodeHot100.哈希表;

import java.util.HashMap;
import java.util.Map;

public class Q1两数之和 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i],i);
        }

        return ans;
    }
}
