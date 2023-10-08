package 回溯算法;

import javax.swing.*;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Q77
{
    //返回1-n的整数数组含k个数的集合可能
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k)
    {
        backTraveling(n,k,1);
        return ans;
    }
    public void backTraveling(int n, int k, int startindex)
    {
        if(list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }
        //for循环这里可以采用减枝优化，当后面的个数不够时，直接跳过后面的递归添加
        for(int i = startindex; i <= n - k + list.size() +1; i++)
        {
            list.add(i);
            backTraveling(n,k,i+1);
            list.remove(list.size() - 1);
        }
    }
}
