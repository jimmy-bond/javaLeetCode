package 力扣每日一题;

import java.util.Arrays;

public class Q1456切割最大面积蛋糕 {
    public static void main(String[] args) {
        System.out.println(maxArea(5, 4, new int[]{3, 1}, new int[]{1}));
    }
    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hmax = Math.max(horizontalCuts[0],h - horizontalCuts[horizontalCuts.length-1]);
        int vmax = Math.max(verticalCuts[0], w -verticalCuts[verticalCuts.length -1]);

        for(int i = 1; i < horizontalCuts.length; i++)
        {
            if(hmax < horizontalCuts[i]- horizontalCuts[i-1])
                hmax = horizontalCuts[i]- horizontalCuts[i-1];
        }
        for(int i = 1; i < verticalCuts.length; i++)
        {
            if(vmax < verticalCuts[i] - verticalCuts[i-1])
                vmax = verticalCuts[i] - verticalCuts[i-1];
        }
        System.out.println(vmax);
        System.out.println(hmax);
        return vmax * hmax;
    }
}
