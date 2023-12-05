package 单调栈;

import java.util.Stack;

public class Q84柱状图中最大的矩形 {

    public static void main(String[] args) {
        int[]h = new int[]{1,2,3};
        System.out.println(h.length);
        int[]w = new int[]{1,5,5,5,5,5,5,5,5};
        h = w;
        System.out.println(h.length);
    }
    public  int largestRectangleArea(int[] heights) {
       int ans = 0;
       //前后加零，是为了防止数组出现升序和降序的结果导致没法计算结果
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }

        heights = newHeights;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < heights.length; i++)
        {
            if(heights[i] >= heights[stack.peek()])
            {
                stack.push(i);
            }
            else
            {
             while (heights[i] < heights[stack.peek()])
             {
                 int mid = stack.pop();
                 int right = i;
                 int left  = stack.peek();
                 int wide = right - left + 1;
                 int h = heights[mid];
                 //因为单调栈里面是降序分布的，所以面积为宽度*高度
                    ans = Math.max(h*wide,ans);
             }
             stack.push(i);
            }
        }
       return  ans;
    }
}
