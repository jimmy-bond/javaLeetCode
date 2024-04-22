package LeetCodeHot100.哈希表;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q49字母异位词分组 {
    @Test
    public void kK()
    {
        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs)
        {
            char[] a = new char[26];
            //统计字符串中每个字符串出现的次数
            for (char c : s.toCharArray())
                a[c - 'a']++;
            String keyStr = String.valueOf(a);
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
