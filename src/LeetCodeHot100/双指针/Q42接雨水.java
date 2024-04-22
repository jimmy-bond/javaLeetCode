package LeetCodeHot100.双指针;

import java.util.Stack;

public class Q42接雨水 {
    //这里是维护一个单调栈，当出现水坑凹槽的时候，先去掉之前计算过的凹槽面积，再计算新的凹槽面积，如果一次之后，新加入的柱子还是高于当前栈顶，则继续while循环
    public int trap(int[] height) {
        int ans = 0;
        if (height == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()])
            {
                int curIdx = stack.pop();
                //当前栈顶元素一直相同的话，全部pop出去
                while(!stack.isEmpty() && height[stack.peek()] == height[curIdx]) stack.pop();
                if(!stack.isEmpty())
                {
                    int Top = stack.peek();
                    //两条柱子之间选最短的然后减去下方已经计算过的雨水再乘于长度
                    ans += (Math.min(height[Top], height[i]) - height[curIdx]) * (i - Top - 1);
                }
            }
            stack.add(i);
        }
        return ans;
    }
}
