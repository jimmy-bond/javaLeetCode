package 单调栈;

import java.util.Stack;
//就近解决
public class Q42接雨水 {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    public static int trap(int[] height) {
        int ans  = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 1; i < height.length; i++)
        {
            if(height[i] < height[stack.peek()])
            {
                stack.push(i);
            }
            else if(height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && height[stack.peek()] < height[i])
                {
                    int mid = stack.pop();

                    if(!stack.isEmpty()){
                        int left = stack.peek();
                        //高度
                        int h = Math.min(height[left], height[i]) - height[mid];
                        int w = i - left - 1 ;
                        int hold = h * w;
                        if (hold > 0){
                            ans += hold;
                            System.out.println(ans);
                        }
                    }

                }
                stack.push(i);
            }
        }
        return ans;
    }
}
