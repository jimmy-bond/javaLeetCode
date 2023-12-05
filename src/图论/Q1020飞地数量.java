package 图论;

public class Q1020飞地数量 {
    int ans = 0;
    int[][]dir = {
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
    };
    public int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if(grid[i][0] == 1) dfs(grid,i,0);
            if(grid[i][grid.length-1] == 1) dfs(grid,i,grid.length-1);
        }
        for(int j = 1; j < grid.length-1; j++)
        {
            if(grid[0][j] == 1) dfs(grid,0,j);
            if(grid[grid.length-1][j] == 1) dfs(grid,grid.length-1,j);
        }
        ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) dfs(grid,i,j);
            }
        }
        return ans;
    }
    public void dfs(int[][]grid, int x, int y)
    {
        if(grid[x][y] == 0) return ;

        grid[x][y] = 0;
        ans++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx <0 || nx >= grid.length || ny < 0|| ny >= grid[0].length)
            {
                continue;
            }
            dfs(grid,nx,ny);
        }

    }
}
//dfs用到的是递归，bfs用到的是迭代在同一层
/*class Solution {
    int count = 0;
    int[][] dir ={
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
    };
    private void bfs(int[][] grid, int x, int y){
        Queue<Integer> que = new LinkedList<>();
        que.offer(x);
        que.offer(y);
        count++;
        grid[x][y] = 0;

        while(!que.isEmpty()){
            int currX = que.poll();
            int currY = que.poll();

            for(int i = 0; i < 4; i++){
                int nextX = currX + dir[i][0];
                int nextY = currY + dir[i][1];

                if(nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length)
                    continue;

                if(grid[nextX][nextY] == 1){
                    que.offer(nextX);
                    que.offer(nextY);
                    count++;
                    grid[nextX][nextY] = 0;
                }
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            if(grid[i][0] == 1)
                bfs(grid, i, 0);
            if(grid[i][grid[0].length - 1] == 1)
                bfs(grid, i, grid[0].length - 1);
        }
        for(int j = 1; j < grid[0].length; j++){
            if(grid[0][j] == 1)
                bfs(grid, 0 , j);
            if(grid[grid.length - 1][j] == 1)
                bfs(grid, grid.length - 1, j);
        }
        count = 0;
        for(int i = 1; i < grid.length - 1; i++){
            for(int j = 1; j < grid[0].length - 1; j++){
                if(grid[i][j] == 1)
                    bfs(grid,i ,j);
            }
        }
        return count;
    }
}*/
