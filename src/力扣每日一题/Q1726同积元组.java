package 力扣每日一题;
import java.util.HashMap;
import java.util.Arrays;
//不是用双指针，用哈希表可以减少复杂度,然后用排列组合计算
//以为是四数之和
class Q1726 {
    public int tupleSameProduct(int[] nums) {
        int ans = 0;
      HashMap<Integer,Integer> hm = new HashMap<>();
      for(int i = 0; i < nums.length; i++)
      {
        for(int j = i +1; j < nums.length; j++)
        {
            hm.put(nums[i]*nums[j],hm.getOrDefault(nums[i]*nums[j],0)+ 1);
        }
      }
      for(Integer i : hm.values())
      {
          ans += i * (i - 1) * 4;
      }
      return ans;
    }
}
//四数之和之类的做法
/*class Solution {
    public int tupleSameProduct(int[] nums) {
        if (nums.length < 4) return 0;
        int ans = 0;
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 3; j < n; j++) {
                int x = nums[i] * nums[j];
                int p = i + 1, q = j - 1;
                while (p < q) {
                    int y = nums[p] * nums[q];
                    if (y == x) {
                        ans++;
                        p++;
                        q--;
                    } else if (y > x) {
                        q--;
                    } else {
                        p++;
                    }
                }
            }
        }
        return ans << 3;
    }
}*/

