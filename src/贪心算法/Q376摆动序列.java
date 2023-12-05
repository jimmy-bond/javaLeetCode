package 贪心算法;

 class Q376 {
     public int wiggleMaxLength(int[] nums) {
         int ans = 1;//默认左边第一个为一个峰值
         int curdif = 0;//现在差值
         int predif = 0;//先前差值
        for(int i = 1; i < nums.length ; i++)
        {
            curdif = nums[i] - nums[i-1];
            if((curdif > 0 && predif < 0) ||(curdif < 0 && predif > 0) )
            {
                ans++;
            }
            predif = curdif;
        }
        return ans + 1;
     }

}
