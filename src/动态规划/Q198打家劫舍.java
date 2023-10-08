package 动态规划;
 class Q198 {
     //找出递推的方程最为重要
     public int rob(int[] nums) {
         int[] danm = new int[nums.length +1 ];
         danm[0] = 0;
         danm[1] = nums[0];
         for(int i = 2; i <= nums.length; i++)
         {
             danm[i] = Math.max(danm[i - 1] ,danm[i -2] +nums[i -1]);
         }
         return danm[nums.length ];
     }
}
