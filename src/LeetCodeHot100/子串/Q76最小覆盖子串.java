package LeetCodeHot100.子串;

import java.sql.Connection;
import java.util.HashMap;
//滑动窗口解决
public class Q76最小覆盖子串 {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABCD"));
    }
    public static String minWindow(String s, String t) {
        if(t == null || s == null || s.length() == 0 || t.length() == 0)
        {
            return "";
        }
        int left = 0 , right = 0,len = Integer.MAX_VALUE , count = 0;
        int tleft = 0, tright = 0;
        int[] ch = new int[128];
        for (int i = 0; i < t.length(); i++) {
            ch[t.charAt(i)]++;
        }
        while(right < s.length())
        {
            if(ch[s.charAt(right)] > 0) {
                count++;
            }
            ch[s.charAt(right)]--;
          //当其中某一个子串符合覆盖子串要求时
            if(count == t.length()){
                // 符合条件时顺便缩减窗口范围
                while(left < right && ch[s.charAt(left)] < 0) {
                    ch[s.charAt(left)]++;
                    left++;
                }
                int tmp = right - left + 1;
                if(tmp < len){
                    len = tmp;
                    tleft = left;
                    tright = right;
                }
            }

            right++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(tleft,tright+1);
    }
}

