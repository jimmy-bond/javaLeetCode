package 力扣每日一题;

import org.testng.annotations.Test;
import org.yaml.snakeyaml.external.com.google.gdata.util.common.base.Escaper;

import javax.management.MXBean;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Q2866美丽塔 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> maxHeights = new ArrayList<>();
        for(int i = 0; i < 6; i++)
        {
            maxHeights.add(sc.nextInt());

        }
        System.out.println(maximumSumOfHeights(maxHeights));
    }
    //前缀和加后缀和计算一遍
    //然后匹配最大值
    public static long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] sufSums = new long[n];   // 后缀和数组
        Stack<Integer> st = new Stack<>();      // 单调栈
        st.push(n);         // 栈底为n表示后缀和边界
        long sufS = 0; // 后缀和
        for(int i = n - 1; i >= 0; i--){
            while(st.size() > 1 && maxHeights.get(i) <= maxHeights.get(st.peek())){
                // 在到达栈底n之前，弹出位于当前位置右侧的小于等于当前位置最大高度的索引
                int t = st.pop();   // 获取要弹出的元素
                sufS -= (long)maxHeights.get(t) * (st.peek() - t);  // 后缀和减去弹出索引对应的区间包含的高度和
            }
            sufS += (long)maxHeights.get(i) * (st.peek() - i);      // 后缀和累加要加入的索引对应的区间包含的高度和
            sufSums[i] = sufS;      // 记录后缀和
            st.push(i);             // 元素入栈
        }
        st.clear(); // 清空栈
        st.push(-1);                // 栈底为-1表示前缀和边界
        long res = 0;  // 结果值
        long preS = 0; // 前缀和
        for(int i = 0; i < n; i++){
            while(st.size() > 1 && maxHeights.get(i) <= maxHeights.get(st.peek())){
                // 在到达栈底-1之前，弹出位于当前位置左侧的小于等于当前位置最大高度的索引
                int t = st.pop();
                preS -= (long)maxHeights.get(t) * (t - st.peek());  // 前缀和和减去弹出索引对应的区间包含的高度和
            }
            preS += (long)maxHeights.get(i) * (i - st.peek());      // 前缀和累加要加入的索引对应的区间包含的高度和
            res = Math.max(res, preS + sufSums[i] - maxHeights.get(i));      // 得到当前位置前后缀和，更新最大值
            st.push(i);     // 元素入栈
        }
        return res;
    }
}
