package 二叉树;

import java.util.HashMap;

//从传递来的数组中递归的选择其中的最大值作为根节点
class Q654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return travel(nums,0,nums.length-1);
    }
    public TreeNode travel(int[] nums, int left, int right)
    {
        if(left > right) return null;
        if(right == left ){
            return new TreeNode(nums[left]);
        }
        int maxindex = nums[left];
        int index = left;
        for(int i = left;i <= right;i++)
        {
            if(maxindex < nums[i]) {
                maxindex = nums[i];
                index = i;
                break;
            }
        }
        TreeNode treeNode = new TreeNode(maxindex);
       treeNode.left = travel(nums,left,index-1);
       treeNode.right = travel(nums,index+1,right);
        return treeNode;
    }
}

