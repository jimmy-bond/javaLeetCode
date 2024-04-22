package LeetCodeHot100.滑动窗口;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Q3无重复字符的最长子串 {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 1) return 1;
        int ans = 0;
        Queue<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
           if(queue.contains(s.charAt(i)))
           {
               ans = Math.max(queue.size(),ans);
               while(queue.contains(s.charAt(i))){
                   queue.poll();
               }
           }
            queue.add(s.charAt(i));
        }
        ans = Math.max(ans,queue.size());
        return ans;
    }
//用数组的时间效率更高
    /*
    char[] s = S.toCharArray(); // 转换成 char[] 加快效率（忽略带来的空间消耗）
    int n = s.length, ans = 0, left = 0;
    boolean[] has = new boolean[128]; // 也可以用 HashSet<Character>，这里为了效率用的数组
        for (int right = 0; right < n; ++right) {
        char c = s[right];
        while (has[c]) // 加入 c 后，窗口内会有重复元素
            has[s[left++]] = false;
        has[c] = true;
        ans = Math.max(ans, right - left + 1); // 更新窗口长度最大值
    }
        return ans;
        */
}
