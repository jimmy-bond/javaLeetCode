package 力扣每日一题;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q907子数组的最小值之和 {
    private  final long MOD = (long) 1e9 + 7;
    public int sumSubarrayMins(int[] arr) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1);
        int[]left = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while(st.size() > 1 && arr[st.peek()] >= arr[i]) st.pop();
            left[i] = st.peek();
            st.push(i);
        }
        int[]right = new int[arr.length];
        st.clear();
        st.push(arr.length);
        for (int i = arr.length-1; i >= 0; i--) {
            while(st.size() > 1 && arr[st.peek()] > arr[i]) st.pop();
            right[i] = st.peek();
            st.push(i);
        }

        long ans = 0;
        for (int i = 0; i < arr.length; ++i)
            ans += (long) arr[i] * (i - left[i]) * (right[i] - i); // 累加贡献
        return (int) (ans % MOD);

    }
}
