package 单调栈;

import java.util.Stack;

public class Q739每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[]ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty()&&temperatures[i] > temperatures[stack.peek()])
            {
                ans[stack.peek()] = i - stack.pop();
            }
                stack.push(i);

        }
        return ans;
    }
}
