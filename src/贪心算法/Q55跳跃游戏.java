package 贪心算法;

 class Q55 {
     public boolean canJump(int[] nums) {
         //用jump来规定到底能跳多远
        if(nums.length == 1) return true;
        int jump = 0;
        for(int i = 0; i <= jump; i++)
        {
            jump = Math.max(jump,i+nums[i]);
            if(jump >= nums.length - 1) return true;
        }
         return false;
         //跳跃游戏2 确定跳到终点所可能的最小跳跃次数
      /*  int count = 0;
        if(nums.length == 1) return count;
        //最大的覆盖区域
        int max;
        //当前下标的最大覆盖区域
        int cur;
        for(int i = 0; i < nums.length; i++)
        {
            //每一次从可到达的范围中找到下一跳可到达的最大范围
            //当i遍历第一跳可到达的最大范围时，说明第二跳也不可到达。
            max  = Math.max(max,i+nums[i]);
            if(max >= nums.length - 1) {
                count ++;
                break;
            }
            if(i == cur)
            {
                //到达当前最大覆盖区域时
                cur = max;
                count ++;
            }
        }
        return count;*/
     }



}
