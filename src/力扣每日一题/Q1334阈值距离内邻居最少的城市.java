package 力扣每日一题;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
public class Q1334阈值距离内邻居最少的城市 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //初始化邻接矩阵
        int[][] w = new int[n][n];
        for (int[] row : w) {
            Arrays.fill(row, Integer.MAX_VALUE / 2); // 防止加法溢出 i=j时距离为无穷大，即无法从自身到达
        }
        for (int[] e : edges) {
            int x = e[0], y = e[1], wt = e[2];
            w[x][y] = w[y][x] = wt;
            //每段距离的权值
        }
        int[][][] memo = new int[n][n][n];

        int ans = 0;
        int minCnt = n;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (j != i && dfs(n - 1, i, j, memo, w) <= distanceThreshold) {
                    cnt++;
                }
            }

            if (cnt <= minCnt) { // 相等时取最大的 i  假如0和3都取最小城市，那么就选择3编号
                minCnt = cnt;
                ans = i;
            }
        }
        return ans;
    }

    private int dfs(int k, int i, int j, int[][][] memo, int[][] w) {
        if (k < 0) { // 递归边界 k为-1
            return w[i][j];
        }
        if (memo[k][i][j] != 0) { // 之前计算过
            return memo[k][i][j];
        }
        return memo[k][i][j] = Math.min(dfs(k - 1, i, j, memo, w),
                dfs(k - 1, i, k, memo, w) + dfs(k - 1, k, j, memo, w));
    }
}
