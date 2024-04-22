package LeetCodeHot100.矩阵;

import java.rmi.MarshalException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q54螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        // 定义四个方向
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int x = 0, y = 0, i = 0 ,d = 0; i < m*n;i++)
        {
            ans.add(matrix[x][y]);
            matrix[x][y] = 101;
            int nx = x + dirs[d%4][0];
            int ny = y + dirs[d%4][1];
            if(nx >= m || nx < 0||ny >= n || ny < 0 || matrix[nx][ny] == 101)
            {
                d++;
                nx = x + dirs[d%4][0];
                ny = y + dirs[d%4][1];
            }
            x = nx;
            y = ny;
        }
    return ans;
    }
}
