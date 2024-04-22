package LeetCodeHot100.回溯;

import java.util.ArrayList;
import java.util.List;

public class Q22括号生成 {

    //全程用到底的变量需要回溯删除
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
            back(n,0,0, new StringBuilder(""));
            return ans;
    }
    public void back(int n,int left, int right,StringBuilder s){
        if(left == right && left == n){
            ans.add(new String(s));
            return;
        }
        if(right > left){
            return;
        }
        if(left < n){
            s.append("(");
            back(n,left+1,right,s);
            s.deleteCharAt(s.length()-1);
        }
        if(right < n){
            s.append(")");
            back(n,left,right+1,s);
            s.deleteCharAt(s.length()-1);
        }
    }

}
