package 动态规划;

import java.lang.reflect.WildcardType;
import java.util.Map;
import java.util.Scanner;

//ACM模式输入
public class a01背包 {
//采用二维数组方式解决
    public  int getMaxValue()
    {
        Scanner sc  =new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        //M表示第i个物品，N表示当前背包的容量
        int[][] array  = new int[M][N];

        int[] weight = new int[M];
        int[] value = new int[M];
        //建立物品的重量和价值数组
        for (int i = 1; i < M; i++) {
           weight[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
           value[i] = sc.nextInt();
        }

        //初始化数组
        for(int j = 0; weight[0] > j; j++)
        {
             array[0][j] = 0;
        }
        for(int j = weight[0]; j < N; j++)
        {
            array[0][j] = value[0];
        }
        for(int i = 1; i < M; i++)
            for(int j = 0; j < N; j++)
            {
                if(j < weight[i]) array[i][j] = value[i-1];
                else{
                    array[i][j] = Math.max(array[i-1][j],array[i-1][j-weight[i]] + value[i]);
                }
            }

        return  array[M -1][N -1];
    }
//也可以用一维数组滚动数组来解决
public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight){
    int wLen = weight.length;
    //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
    int[] dp = new int[bagWeight + 1];
    //遍历顺序：先遍历物品，再遍历背包容量
    for (int i = 0; i < wLen; i++){
        for (int j = bagWeight; j >= weight[i]; j--){
            //假如正序遍历的话会造成重复物品的添加
            //因为这样会造成dp【i+1】是由dp【i】累加的
            dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
        }
    }

}
}
