package 单调栈;

import java.util.Arrays;
import java.util.Stack;

public class Q503循环数组下一个更大元素II {
    public static void main(String[] args) {
      int[]ans = nextGreaterElements(new int[]{1,2,3,4,5});
      for(int i : ans) System.out.println(i + " ");

    }
    public static int[] nextGreaterElements(int[] nums) {
        int[]ans = new int[nums.length];
        Arrays.fill(ans,-1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < 2*ans.length; i++) {
            while(!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek() % nums.length])
            {
                ans[stack.peek()] =  nums[i%nums.length];
                stack.pop();
            }
            stack.push(i%nums.length);
        }
        return ans;
    }
}
