package 回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//求一个数组的子集，n个数据的数组有2^n个子集
class Q78 {
    public static void main(String[] args) {
        Q78 q = new Q78();
        int[] num = {1,2,3};
        q.backTraveling(num,0);

    }
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
       backTraveling(nums,0);
        return  ans;

    }
    public void backTraveling(int [] nums,int startindex)
    {
        ans.add(new ArrayList<>(list));
        if(startindex >= nums.length)
        {
            return;
        }
        for(int i  = startindex; i < nums.length; i++)
        {
            list.add(nums[i]);
            backTraveling(nums,i + 1);
            list.removeLast();
        }
    }
}
