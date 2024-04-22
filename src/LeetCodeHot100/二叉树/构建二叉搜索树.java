package LeetCodeHot100.二叉树;

public class 构建二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
       return build(nums,0,nums.length-1);
    }
    private TreeNode build(int[] nums, int left,int right){
        if(left > right){
            return null;
        }
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums,left,mid-1);
        root.right = build(nums,mid + 1,right);
        return root;
    }
}
