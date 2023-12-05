package 动态规划;
//采用中心扩散法
public class Q647回文字符串 {
    public int countSubstrings(String s) {
        int ans = 0;
        //总共有 2*n - 1 个中心点可以扩散
        //n个单字符和n-1个双字符
        for (int i = 0; i < 2*s.length() - 1; i++) {
            //left 和 right有两种结果，要么是 left == right 或者 right == left + 1，分别代表单字符和双字符
            int left = i/2;
            int right = left + i%2;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
            {
                left --;
                right ++;
                ans++;
            }
        }
        return ans;
    }
}
