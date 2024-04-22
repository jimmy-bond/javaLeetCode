package 力扣每日一题;

import org.testng.annotations.Test;

import java.util.Map;

public class Q1690石子游戏 {
    //这里涉及了前缀和，记忆化搜索的方法
    //要考虑出他们的状态转移方程
    public int stoneGameVII(int[] stones) {
        int[] suf = new int[stones.length + 1];
        suf[0] = 0;
        for(int i = 1; i <= stones.length; i++)
        {
            suf[i] = suf[i-1] + stones[i-1];
        }
        int[][] m  = new int[stones.length +1][stones.length + 1];
        return dfs(0,stones.length,suf, m);
    }
    public int dfs(int head, int tail, int[]s, int[][]memo){
        if(head == tail) return 0;
        if(memo[head][tail] > 0) return memo[head][tail];
        int res1 = s[tail] - s[head+1] - dfs(head + 1,tail,s, memo);
        int res2 = s[tail-1] - s[head] - dfs(head,tail-1,s, memo);
        return memo[head][tail] = Math.max(res1,res2);
     }
     @Test
    public void kk(){
         System.out.println(stoneGameVII(new int[]{7,90,5,1,100,10,10,2}));
     }
     //动态规划方法
    public int stoneGame(int[] stones) {
        int n = stones.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] += s[i] + stones[i];
        }
        int[][] f = new int[n][n];
        //从倒数第一行开始计算结果，而且是从右下角开始计算，具体顺序要看状态转移方程，自底向上
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = Math.max(s[j + 1] - s[i + 1] - f[i + 1][j], s[j] - s[i] - f[i][j - 1]);
            }
        }
        return f[0][n - 1];
    }


}