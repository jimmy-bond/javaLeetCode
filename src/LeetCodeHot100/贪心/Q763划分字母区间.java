package LeetCodeHot100.贪心;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Q763划分字母区间 {
    @Test
    public void kk(){
        partitionLabels("ababcbacadefegdehijhklij");
    }
    public List<Integer> partitionLabels(String s) {
    List<Integer> ans = new ArrayList<>();
    int start = 0, end = 0;
    int[]a = new int[26];
    for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            a[c-'a'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int max = a[c-'a'];
            end = Math.max(end,max);
            if(i == end ){
                ans.add(end - start + 1);
                start = end + 1;
            }

        }
    return  ans;
    }
}
