package LeetCodeHot100.回溯;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Q131分割字符回文串 {
    List<String> path = new ArrayList<>();
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTraveling(s,0);
        return ans;
    }
    public void backTraveling(String s, int head){
        if(head == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
       for(int i = head; i < s.length(); i++){
            if(isPalindrome(s,head,i)){
                path.add(s.substring(head,i+1));
            }
            else {
                continue;
            }
            backTraveling(s,i+1);
            path.remove(path.size()-1);
       }
    }
    //迭代判断回文串
    public boolean isPalindrome(String s,int head, int end)
    {
        for (int i = head, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean is(String s, int head, int end){
        if(head <= end ){
            return s.charAt(head) == s.charAt(end) && is(s,head + 1,end -1);
        }
        return true;
    }
}
