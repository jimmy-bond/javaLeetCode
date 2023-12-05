package 力扣每日一题;

import java.util.Arrays;
//用数组存储每篇论文的引用数量
//最后累加即可得到答案
public class Q274H指数 {
    public int hIndex(int[] citations) {
        int[]cnt = new int[citations.length + 1];
        for(int i : citations)
        {
            int a = Math.min(i,citations.length);
            cnt[a] ++;
        }
        int s = 0;
        for(int i = citations.length; ;i--)
        {
            s += cnt[i];
            if(s >= i)
                return i;
        }
    }
}
