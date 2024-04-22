package 回溯算法;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39组合总和 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    @Test
    public void kk(){
        combinationSum(new int[]{2,3,6,7},7);
        System.out.println(ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,0,0);
        return ans;
    }
    public void dfs(int[]candidates,int target, int val, int index){
        if(val == target) {
            ans.add(new ArrayList<>(path));
        }
        else{
            if(val > target) return;
            for(int i = index; i < candidates.length; i++){
                path.add(candidates[i]);
                dfs(candidates,target,val + candidates[i],i);
                path.remove(path.size()-1);
            }
        }
    }
}
