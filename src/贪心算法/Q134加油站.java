package 贪心算法;

class Q134 {
    //加油站
    //能通过的话就是总加油量大于总费油量
    //并且从某一个位置开始持续总和会大于0
    public int canCompleteCircuit(int[] gas, int[] cost)
    {
        int sum = 0;
        for(int i = 0; i < gas.length; i++)
        {
            int res = gas[i] + cost[i];
            sum += res;
        }
        if(sum < 0) return -1;
        else{
            int id =0;
            int cursum = 0;
            for(int i = 0; i < gas.length; i++)
            {
                cursum += gas[i] - cost[i];
                if(cursum < 0)
                {
                    id  = i;
                    cursum = 0;
                }
            }
            return cursum;
        }
    }
}
