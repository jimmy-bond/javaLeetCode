package 回溯算法;

import sun.nio.cs.FastCharsetProvider;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//这个和分割回文串一样，重点是分割线的划定和对分割失败后的回溯删减
//回溯后删除添加的那个点就行
class Q93 {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        backTracking(sb, 0, 0);
        return result;
    }
    private void backTracking(StringBuilder s, int startIndex, int dotCount){
        if(dotCount == 3){
            if(isValid(s.toString())){
                result.add(s.toString());
            }
            return;
        }
        for(int i = startIndex; i < s.length(); i++){
            if(isValid(s.toString())){
                s.insert(i + 1, '.');
                backTracking(s, i + 2, dotCount + 1);
                s.deleteCharAt(i + 1);
            }else{
                break;
            }
        }
    }
    public static   boolean isValid(String s)
    {
        if(s.length() > 1 && s.charAt(0) =='0') return false;
        if(s.length() == 0) return false;
        if(s.length() > 3) return false;
        return Integer.parseInt(s) <= 255;
    }
}
