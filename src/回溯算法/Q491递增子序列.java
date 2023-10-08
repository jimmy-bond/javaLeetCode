package 回溯算法;

import java.text.BreakIterator;
import java.util.LinkedList;
import java.util.List;

class Q491 {
    List<List<Integer>> ans = new LinkedList<>();
    List<Integer> path = new LinkedList<>();

     public List<List<Integer>> findSubsequences(int[] nums) {

        backTraveling(nums,0);
        return  ans;
    }
    public void backTraveling(int[] nums, int startindex)
    {
        if(path.size() >=2){
            ans.add(new LinkedList<>(path));
        }
        int [] used = new int[201];
        for(int i = startindex; i < nums.length ; i++)
        {

           if((path.size() > 0&&nums[i] < path.get(path.size() -1))||used[nums[i] + 100] == 1)
           {
               continue;
           }
           path.add(nums[i]);
           used[nums[i] +100] = 1;
            backTraveling(nums,i +1 );
           path.remove(path.size() -1);
        }
    }

}
