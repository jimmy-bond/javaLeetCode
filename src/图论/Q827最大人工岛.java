package 图论;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q827最大人工岛 {
    public int largestIsland(int[][] grid) {
     int ans = 0;
     int mark = 2;
     Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    map.put(mark, dfs(grid, i, j, mark));
                }
                mark++;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0){
                   Set<Integer> set = new HashSet<>();
                   int temp = 0;
                   for(int[] a : dir)
                   {
                       int ni = i + a[0];
                       int nj = j + a[1];
                       if(ni < 0|| nj < 0|| ni >= grid.length || nj >= grid[0].length) continue;
                       if(set.contains(grid[ni][nj]) || !map.containsKey(grid[ni][nj])) continue;
                       set.add(grid[ni][nj]);
                       temp += map.get(grid[ni][nj]);
                   }
                   ans = Math.max(ans,temp + 1);
                }
            }
        }
return ans == 0 ? grid.length * grid.length: ans;
    }


    static int[][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public static int dfs(int[][]grid,int x, int y,int mark)
    {
        int ans = 1;
        grid[x][y] = mark;
        for (int[] ints : dir) {
            int nx = x + ints[0];
            int ny = y + ints[1];
            if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) continue;
            if(grid[nx][ny] == 1){
                ans += dfs(grid, nx, ny, mark);
            }
        }
        return ans;

    }

}
