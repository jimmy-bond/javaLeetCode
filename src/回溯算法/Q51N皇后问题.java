package 回溯算法;
import org.testng.internal.ParameterHolder;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
 class Q51 {
     List<List<String>> ans = new LinkedList<>();
     public List<List<String>> solveNQueens(int n)
     {
         char [][] a = new char[n][n];
         for(char[] c :a)
         {
             Arrays.fill(c,'.');
         }
             backTraveling(0,a);
                return ans;
     }
     public void backTraveling(int row, char[][]a)
     {
         //row 表示运行到第几行
         if(row == a.length)
         {
             //到达棋盘
             ans.add(arraytolist(a));
             return;
         }
        for(int col = 0; col < a.length; col ++)
        {
            if(isValid(row,col,a))
            {
                a[row][col] = 'Q';
                backTraveling(row +1,a);
                a[row][col] = '.';
            }
        }

     }
    public List<String>  arraytolist(char[][]a)
    {
        List<String> list = new LinkedList<>();
        for(char[] c : a)
        {
            list.add(String.copyValueOf(c));
        }
        return list;
    }
     public Boolean isValid(int row, int col, char[][]a)
     {
        for(int i = 0; i < row; i++)
        {
            //判断同一列中是否有Q皇后
            if(a[i][col] == 'Q'){
                return false;
            }

        }
        //判断左上是否有
        for(int i = row -1, j = col -1; i>= 0&&j >=0; i--,j--){
                if(a[i][j] == 'Q')
                {
                    return false;
                }
        }
        //判断右上角是否有
         for(int i = row -1,j = col +1; i >= 0 && j <= a.length; i--,j++)
         {
             if(a[i][j] == 'Q') return false;
         }
         return true;
     }


}
