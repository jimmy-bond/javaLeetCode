import java.util.Scanner;

class Solution5 {
    public static void main(String[] args) {

    }
    public static String longestPalindrome(String s) {
        int start = 0, end = 0, n = s.length();
        int i = 0;
        while (i < n) {
            int left = i, right = i;
            //如果后面有连续相同字符，把right向右扩展到最后一个相同字符的位置，
            //并把i设置到该位置的下一个位置。
            //因为每次循环i左边的字符一定和i不相同，所以不需要将left向左扩展
            while (right < n - 1 && s.charAt(right + 1) == s.charAt(left)) {
                right++;
            }
            i = right + 1;
            while (left > -1 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (right - left - 1> end - start) {
                end = right;
                start = left + 1;
            }
        }
        return s.substring(start, end);
    }


    }

