package LeetCodeHot100.回溯;

import org.testng.annotations.Test;
import org.yaml.snakeyaml.events.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q17电话字母组合 {
    StringBuilder sb = new StringBuilder();
    List<String> ans = new ArrayList<>();
    String[]strings = {"","","abc","def","ghi","klm","nop","qrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits == null) return ans;
        backTraveling(digits,0);
     return ans;
    }
    private void backTraveling(String digits, int index){
        if(index == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String string = strings[digits.charAt(index) - '0'];
        for(int i = 0; i < string.length(); i++){
            sb.append(string.charAt(i));
            backTraveling(digits,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    @Test
    public void  kk(){
    letterCombinations("");
        System.out.println(ans);
    }
}
