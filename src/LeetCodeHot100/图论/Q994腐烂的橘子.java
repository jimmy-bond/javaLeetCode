package LeetCodeHot100.图论;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q994腐烂的橘子 {
    @Test
    public void kk(){
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int ans = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j] == 1) ans++;
                else if(grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                }
            }
        }
        int time = 0;
        while(!queue.isEmpty() && ans > 0){
            int len = queue.size();
            time++;
            for (int i = 0; i < len; i++) {
                int[]a = queue.poll();
                int x = a[0];
                int y = a[1];
                for (int[] ints : dir) {
                    if (x + ints[0] < r && x + ints[0] >= 0 && y + ints[1] < c && y + ints[1] >= 0) {
                        if (grid[x+ints[0]][y+ints[1]] == 1) {
                            grid[x+ints[0]][y+ints[1]] = 2;
                            ans--;
                            queue.add(new int[]{x+ints[0], y+ints[1]});
                        }
                    }
                }
            }
        }
    return ans == 0 ? time:-1;
    }
}
