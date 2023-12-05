package 图论;

public class Q200岛屿数量 {
    public int numIslands(char[][] grid) {
        int res = 0; //记录找到的岛屿数量
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                //找到“1”，res加一，同时淹没这个岛
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    public void dfs(char[][]grid,int i, int j)
    {
        if(i < 0 || i >= grid.length || j < 0|| j >=grid[i].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
