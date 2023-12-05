package 图论;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Q417太平洋和大西洋问题 {

    private int[][]dir = {{-1,0},{1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][]visited1 = new boolean[heights.length][heights[0].length];
        boolean[][]visited2 = new boolean[heights.length][heights[0].length];
        for(int i = 0; i < heights.length; i++)
        {
            dfs(heights,visited1,i,0);
            dfs(heights,visited2,i,heights[0].length-1);
        }

        for(int j  = 0; j < heights[0].length; j++)
        {
            dfs(heights,visited1,0,j);
            dfs(heights,visited2,heights.length-1,j);
        }
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if(visited1[i][j] && visited2[i][j]) {
                    List<Integer> a = new ArrayList<>();
                    a.add(i);
                    a.add(j);
                    list.add(a);
                }
            }
        }
        return list;
    }
    public void dfs(int[][]heights, boolean[][]visited, int x, int y)
    {
        if(visited[x][y]) return;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx < 0 || nx >= heights.length || ny <0 || ny >= heights[0].length){
                continue;
            }
            if(heights[nx][ny] < heights[x][y]) {
                continue;
            }
            dfs(heights,visited,nx,ny);
        }
    }

}
