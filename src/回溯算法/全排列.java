package 回溯算法;

import java.util.LinkedList;
import java.util.List;

class 全 {
    List<List<Integer>> ans = new LinkedList<>();
    List<Integer> path  = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        int [] used = new int[21];
        back(nums,used);
        return ans;
    }
    public  void  back(int [] nums,int []used)
    {
        if(path.size() == nums.length)
        {
            ans.add(new LinkedList<>(path));
            return;
        }
        for(int i : nums)
        {
            if(used[i + 10] == 1) continue;
            path.add(i);
            used[i +10] = 1;
            back(nums,used);
            path.remove(path.size() - 1);
            used[i + 10] = 0;
        }
    }
}
