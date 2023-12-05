package 贪心算法;
//当遇到nums[i-1] > nums[i]时
//把nums[i]调为9，nums[i - 1]减减/
 //这样就能最快得出要求的递增数字
public class Q738单调递增数字 {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int start = s.length();
        for (int i = s.length() - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                start = i+1;
            }
        }
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
