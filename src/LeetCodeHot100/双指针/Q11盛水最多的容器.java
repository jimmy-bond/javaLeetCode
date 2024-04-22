package LeetCodeHot100.双指针;

import org.testng.annotations.Test;

import javax.swing.text.AbstractDocument;

public class Q11盛水最多的容器 {
    @Test
    public void kk()
    {
        System.out.println(maxArea(new int[]{1,3,2,5,25,24,5}));
    }
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;


    }
}
