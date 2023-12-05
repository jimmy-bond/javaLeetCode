package 动态规划;
 class Q96 {
     //每个dp【i】等于以j为头节点时，左子树的搜索树*右子树的搜索树的数量
         public int numTrees(int n) {
             if(n < 3) return n;
             int[] dp = new int[n+1];
             dp[1] = 1;
             dp[2] = 2;
             dp[0] = 1;
             for(int i = 3; i < n +1 ; i++)
             {
                 //对于第i个节点，需要考虑1作为根节点直到i作为根节点的情况，所以需要累加
                 //一共i个节点，对于根节点j时,左子树的节点个数为j-1，右子树的节点个数为i-j
                 for(int j = 1; j <= i; j++)
                 {
                     dp[i] += dp[i-j] * dp[j - 1];
                 }
             }
             return dp[n];
         }
}
