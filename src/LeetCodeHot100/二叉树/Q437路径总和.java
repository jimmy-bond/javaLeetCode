package LeetCodeHot100.二叉树;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

public class Q437路径总和 {
    int ans = 0;
    int t ;
    Map<Long,Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        t = targetSum;
        return ans;
    }
    public void dfs1(TreeNode root){
        if(root == null) return ;
        dfs2(root,root.val);
        dfs1(root.left);
        dfs1(root.right);
    }
    public void dfs2(TreeNode root, long val){
        if(val == t) ans++;
        if(root.left != null){
            dfs2(root.left,root.left.val + val);
        }
        if(root.right != null){
            dfs2(root.right,root.right.val + val);
        }

    }
    public void dfs(TreeNode root, int val){
        if(map.containsKey(val-t)) ans += map.get(val- t);
        map.put((long) val,map.getOrDefault(val,0)+1);
        if(root.left != null) dfs(root.left,val + root.left.val);
        if(root.right != null) dfs(root.right,val + root.right.val);
        map.put((long) (val),map.get(val - t) - 1);
    }

}
class Solution {
    Map<Integer, Integer> prefixMap;
    int target;

    public int pathSum(TreeNode root, int sum) {
        prefixMap = new HashMap<>();
        target = sum;
        //key是前缀和， value是该前缀和的路径数量
        prefixMap.put(0, 1);
        return recur(root, 0);
    }

    private int recur(TreeNode node, int curSum) {
        if(node == null) {
            return 0;
        }

        int res = 0;
        curSum += node.val;

        res += prefixMap.getOrDefault(curSum - target, 0);
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1);

        int left = recur(node.left, curSum);
        int right = recur(node.right, curSum);

        res = res + left + right;
        //最后恢复状态
        prefixMap.put(curSum, prefixMap.get(curSum) - 1);

        return res;
    }
}

