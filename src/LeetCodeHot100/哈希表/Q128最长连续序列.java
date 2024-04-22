package LeetCodeHot100.哈希表;

import java.util.HashSet;
import java.util.Set;

public class Q128最长连续序列 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int a : nums)
        {
            set.add(a);
        }
        int ans = 0;
        for(int a : set){
            if(!set.contains(a-1)){
                int cur = a;
                while(set.contains(a+1)){
                    cur++;
                }
                ans = Math.max(ans,cur - a + 1);
            }
        }
        return ans;
    }

}
