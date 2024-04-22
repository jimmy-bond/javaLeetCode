package LeetCodeHot100.矩阵;

public class Q240搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if(matrix[i][0] > target) break;
            int l = 0, r = n-1;
            while(l <= r){
                int mid = (l+r) >> 1;
                if(matrix[i][mid] > target) r = mid - 1;
                else if(matrix[i][mid] < target) l = mid + 1;
                else  return true;
            }
        }
        return false;
    }
}
