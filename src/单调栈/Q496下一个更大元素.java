package 单调栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
//还得是我的map遍历啊

public class Q496下一个更大元素 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       int[]ans = new int[nums1.length];
        Map<Integer,Integer> m = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[0]);
        for(int i = 1; i < nums2.length; i++)
        {
            while ( !stack.isEmpty()&&nums2[i] > stack.peek())
            {
                m.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < ans.length; i++) {
            if(m.containsKey(nums1[i])) ans[i] = m.get(nums1[i]);
            else ans[i] = -1;
        }
       return ans;


    }
}
