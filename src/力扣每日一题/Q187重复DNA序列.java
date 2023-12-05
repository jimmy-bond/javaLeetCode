package 力扣每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q187重复DNA序列 {
    //用哈希表来存储需要重复检验的序列，然后逐一比较即可
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
    public static List<String> findRepeatedDnaSequences(String s) {
        //AAAAACCCCC AAAAACCCCC CAAAAAGGGTTT
        List<String> list = new ArrayList<>();
        if(s.length() <10) return list;
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
        {
            if(i + 10 < s.length()+1)
            {

                String a = s.substring(i,i+10);
                if(hashMap.containsKey(a)){
                    if(list.contains(a)) continue;
                    list.add(a);
                }
                else {
                    hashMap.put(a,1);
                }
            }
            else{
                break;
            }
        }
        return list;
    }
}
