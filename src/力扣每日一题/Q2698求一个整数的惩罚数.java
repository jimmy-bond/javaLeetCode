package 力扣每日一题;

import java.util.ConcurrentModificationException;
//回溯法
public class Q2698求一个整数的惩罚数 {
    public static void main(String[] args) {
        System.out.println(punishmentNumber(37));
    }
    public static int punishmentNumber(int n) {
        int ans =0;
        for(int i = 1; i <= n; i++)
        {
            int count = i * i;
            String s = Integer.toString(count);
            if(backtraveling(s,i,0,0)){
                System.out.println(count);
                ans += count;
            }
        }
        return ans;

    }
    public  static boolean backtraveling(String s,int ans,int count,int startindex)
    {
        if(count == ans && startindex == s.length() ) return true;
        for(int i = startindex; i < s.length(); i++)
        {
            int a =Integer.parseInt(s.substring(startindex,i+1));
            count +=a;
            if(backtraveling(s,ans,count,i+1))  return  true;
            count -= a;
        }
        return false;
    }
}
