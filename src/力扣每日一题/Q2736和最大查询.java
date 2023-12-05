package 力扣每日一题;

import java.beans.beancontext.BeanContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2736和最大查询 {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = queries[i][0];
            pair[i][1] = queries[i][1];
        }
        //降序排列组成的组合
        Arrays.sort(pair, (x, y) -> y[0] - x[0]);
        Integer[] q = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            q[i] = i;
        }
        Arrays.sort(q, (x, y) -> queries[y][0] - queries[x][0]);


        int[] ans = new int[queries.length];
        List<int[]> st = new ArrayList<>();
        int j = 0;
        for (int i : q) {
            int x = queries[i][0];
            int y = queries[i][1];
            //这里已经做了判断大于x，下面只看判断大于y的
            for (; j < n && pair[j][0] >= x; j++) {
                while (!st.isEmpty() && st.get(st.size() - 1)[1] <= pair[j][0] + pair[j][1]) {
                    st.remove(st.size() - 1);
                }
                if (st.isEmpty() || st.get(st.size() - 1)[0] < pair[j][1]) {
                    //这个充当单调栈的作用，来存储y的值和结果和
                    st.add(new int[]{pair[j][1], pair[j][0] + pair[j][1]});
                }
                int p = lowbound(st, y);
                ans[i] = p < st.size() ? st.get(p)[1] : -1;


            }

        }
        return ans;
    }

    public int lowbound(List<int[]> st, int target)
    {
        int left = -1, right = st.size(); // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            int mid = (left + right) >>> 1;
            if (st.get(mid)[0] >= target) {
                right = mid; // 范围缩小到 (left, mid)
            } else {
                left = mid; // 范围缩小到 (mid, right)
            }
        }
        return right;

    }
}
