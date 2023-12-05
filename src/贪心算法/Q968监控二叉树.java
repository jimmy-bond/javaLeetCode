package 贪心算法;
class TreeNode {
      int val;
    TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Q968{
    int count;
    public int minCameraCover(TreeNode root) {
       if(explore(root) == 0) count++ ;
        return count;
    }
    public int explore(TreeNode root)
    {
        //从下到上遍历，左右中，只能看到下面的节点状态，由下面节点状态来推断上面父节点的状态
        //给每个节点设置状态值
        //0 表示没有覆盖到-- 1 表示摄像头占领 -- 2 表示有覆盖到
        if(root == null) return 2;
        int left = explore(root.left);
        int right = explore(root.right);
       if(left == 2 && right == 2) return 0;//叶子节点返回 0
        if(left == 0 || right == 0) {
            //叶子节点的父节点
            count++;
            return  1;
        }
        if(left == 1 || right == 1) {
            return  2;
        }

        return  0;
    }

}
