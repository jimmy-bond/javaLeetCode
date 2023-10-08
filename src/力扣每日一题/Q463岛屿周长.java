package 力扣每日一题;

class Q463 {
    public int islandPerimeter(int[][] grid) {
        for(int i = 0 ; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1){
                    return dfs(grid,i,j);
                }

            }
        return 0;
    }
    public int dfs(int[][] grid,int r, int c)
    {
        if(r < 0 || r > grid.length -1 || c <0 || c>grid[0].length -1){
            return 1;
        }
        if(grid[r][c] == 0)
        {
            return  1;
        }

        if(grid[r][c] != 1)
        {
            return  0;
        }
        //用来标志已经遍历过的数组
        grid[r][c] = 2;
        return dfs(grid,r -1,c) + dfs(grid,r+1,c)+dfs(grid,r,c+1)+dfs(grid,r,c- 1);
    }

}
