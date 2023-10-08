package 滑动窗口;

import com.sun.media.sound.SoftTuning;
import org.testng.annotations.Test;

//最小覆盖子串
//根据数组值判断，直接跳过for循环判断
public class Q76
{
        public String minWindow(String s, String t)
        {
            //当字符串为零时，返回“”
            if(t == null || s == null || s.length() == 0 || t.length() == 0)
            {
                return  "";
            }
            int left = 0, right = 0, minstrat = 0, minend = 0, len = Integer.MAX_VALUE ;
            int count = t.length();
            int [] need = new int[128];//need数组包含所有字符
            //对应字符数目计数
            for (int i = 0; i < t.length(); i++)
            {
                need[t.charAt(i)]++;
            }
            while (right < s.length())
            {
                //当为所需要字符时并且count 》 0
                if(need[s.charAt(right)] > 0 )
                {
                    count--;
                }
                need[s.charAt(right)]--;
            if(count == 0)
             {
                 //减去多余的字符
                 while (left < right && need[s.charAt(left)] < 0)
                 {
                    need[s.charAt(left)] ++;
                    left++;
                 }
                 //判断最小字符串
                    if(right - left + 1 < len)
                    {
                        len = right - left + 1;
                        minstrat = left;
                        minend = right;
                    }

               need[s.charAt(left)]++;
               left++;
               count++;
             }

                right++;
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(minstrat,minend+1);

        }
    @Test
    void kk()
    {
        System.out.println(minWindow("A", "A"));
    }
}
