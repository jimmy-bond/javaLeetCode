package LeetCodeHot100.回溯;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Q78子集 {
    @Test
            public void kk(){
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    List<Integer>path = new ArrayList<>();
    List<List<Integer>> ans =  new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTraveling(nums,0);
        return ans;
    }

    private void backTraveling(int[] nums, int i) {
        ans.add(new ArrayList<>(path));
        if(i >= nums.length) return;
        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            backTraveling(nums,j+1);
            path.remove(path.size()-1);
        }
    }
}
