package 动态规划;
import java.util.HashSet;
import java.util.List;
public class Q139单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict)
    {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i && !valid[i]; j++) {
                if (set.contains(s.substring(j, i)) && valid[j]) {
                    //valid[j]表示的是前面第几个单词可以由字典组成
                    valid[i] = true;
                }
            }
        }

        return valid[s.length()];
    }
}
